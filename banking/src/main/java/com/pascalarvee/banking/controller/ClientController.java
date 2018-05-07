/**
 * 
 */
package com.pascalarvee.banking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pascalarvee.banking.service.ClientService;

/**
 * @author PASCAL
 *
 */

@Controller
@RequestMapping("/admin")
public class ClientController {
	
	@Autowired
	private ClientService clientService;
	
	@RequestMapping("/users")
	public String showAllClients(Model model){
		model.addAttribute("users", clientService.getAllClients());
		
		return "users";
	}
	
	@RequestMapping("/users/{userId}")
	public String showSpecificClient(Model model, @PathVariable("userId") String userId){
		model.addAttribute("user", clientService.getClientByID(Integer.valueOf(userId)));
		
		return "user";
	}
	
	@RequestMapping("/users/deleteUser/{userId}")
	public String deleteClient(Model model, @PathVariable("userId")String userId){
		clientService.desactivateClient(Integer.valueOf(userId));
		
		return "redirect:/admin/users";
	}
}
