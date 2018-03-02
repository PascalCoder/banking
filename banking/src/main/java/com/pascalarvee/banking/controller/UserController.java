/**
 * 
 */
package com.pascalarvee.banking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pascalarvee.banking.service.UserService;

/**
 * @author PASCAL
 *
 */

@Controller
@RequestMapping("/admin")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/users")
	public String showAllUsers(Model model){
		model.addAttribute("users", userService.getAllUsers());
		
		return "users";
	}
	
	@RequestMapping("/users/{userId}")
	public String showSpecificUser(Model model, @PathVariable("userId") String userId){
		model.addAttribute("user", userService.getUserByID(userId));
		
		return "user";
	}
	
	@RequestMapping("/users/deleteUser/{userId}")
	public String deleteUser(Model model, @PathVariable("userId")String userId){
		userService.desactivateUser(userId);
		
		return "redirect:/admin/users";
	}
}
