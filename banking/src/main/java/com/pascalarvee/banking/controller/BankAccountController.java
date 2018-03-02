/**
 * 
 */
package com.pascalarvee.banking.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.pascalarvee.banking.domain.BankAccount;
import com.pascalarvee.banking.domain.Transaction;
import com.pascalarvee.banking.domain.User;
import com.pascalarvee.banking.service.BankAccountService;
import com.pascalarvee.banking.service.UserService;

/**
 * @author PASCAL
 *
 */

@Controller
public class BankAccountController { /**User will be able to add a new account (checking or savings)*/
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private BankAccountService bankAccountService;
	
	User user;
	BankAccount bankAccount;
	Transaction transaction;
	String accountNumber;
	
	@RequestMapping("/addAccount")
	public String addAccount(Model model){ //calculus 2 practice final exam with solutions
		
		return "addAccount";
	}
	
	@RequestMapping(value = "/addAccount", method=RequestMethod.POST)
	public String addAccountPost(@Valid Model model, @ModelAttribute("user")User user){
		
		return "newAccountSuccess";
	}
	
	@RequestMapping("/bankAccount/{userId}")
	public String showDetails(@PathVariable("userId")String userId, Model model){
		
		User user = userService.getUserByID(userId);
		
		model.addAttribute("user", user);
		
		return "accountDetails";
	}
	
	@RequestMapping(value="/addRecipient/{userId}", method=RequestMethod.GET)
	public String addRecipient(@PathVariable("userId")String userId, Model model){
		
		user = userService.getUserByID(userId);
		
		model.addAttribute("user", user);
		
		return "addRecipient";
	}
	
	@RequestMapping(value="/addRecipient", method=RequestMethod.POST)
	public String addRecipientPost(@RequestParam("accountNumber")String accountNumber,
								   @RequestParam("accountType")String accountType){ /*, BindingResult result*/
		
		BankAccount bankAccount = bankAccountService.getBankAccountByAccountNumber(accountNumber);
		
		if(bankAccount == null){
			//result
			return "recipientForm";
		}
		
		User receiver = bankAccount.getUser();
		System.out.println("Receiver: " + receiver.getFirstName() + " " + receiver.getLastName());
		
		bankAccountService.addTransactionRecipient(user.getUserId(), accountNumber);	
		
		return "redirect:transaction/transfer/" + user.getUserId() + "?accountType=checking";
	}
}
