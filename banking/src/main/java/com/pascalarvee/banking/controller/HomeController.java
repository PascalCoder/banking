/**
 * 
 */
package com.pascalarvee.banking.controller;

import java.security.Principal;
import java.util.LinkedList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pascalarvee.banking.domain.BankAccount;
import com.pascalarvee.banking.service.UserService;

/**
 * @author PASCAL ARVEE
 *
 */

@Controller
public class HomeController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/admin")
	public String showAdminPage(){
		return "admin";
	}
	
	@RequestMapping("/")/**returns the home page*/
	public String login(@RequestParam(value="error", required=false)String error,
			            @RequestParam(value="logout", required=false)String logout, Model model){
		
		model.addAttribute("greeting", "Welcome to our banking system!");
		model.addAttribute("subtitle", "Experience our amazing app!");
		
		if(error != null){
			model.addAttribute("error", "Invalid username and/or password!");
		}
		
		if(logout != null){
			model.addAttribute("msg", "You have been successfully logged out!");
		}
		
		return "home";
	}
	
	@RequestMapping("/default")
	public String returnDefault(Principal principal, Model model){ //@AuthenticationPrincipal User activeUser,
		
		/*if(((Authentication)principal).getPrincipal() == null){
			return "redirect:/";
		}*/
		User activeUser;
		try{
			activeUser = (User)((Authentication)principal).getPrincipal();
		}catch(NullPointerException e){
			e.printStackTrace();
			return "redirect:/";
		}
		
		
		com.pascalarvee.banking.domain.User user = userService.getUserByUsername(activeUser.getUsername());
		
		LinkedList<BankAccount>bankAccounts =  new LinkedList<>();
		
		if(!activeUser.getUsername().equalsIgnoreCase("admin")){
			LinkedList<BankAccount> temp = new LinkedList<>(user.getBankAccounts());
			
			for(BankAccount ba : temp){
				if(ba.getAccountType().equalsIgnoreCase("Checking")){
					bankAccounts.addFirst(ba);
				}else if (ba.getAccountType().equalsIgnoreCase("Savings")){
					bankAccounts.add(1, ba);
				}else{
					bankAccounts.add(ba);
				}
			}
			model.addAttribute("bankAccounts", bankAccounts);
		}
		
		model.addAttribute("user", user);
		
		
		return "default";
	}
}
