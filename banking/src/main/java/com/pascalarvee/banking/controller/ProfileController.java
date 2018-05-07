/**
 * 
 */
package com.pascalarvee.banking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pascalarvee.banking.domain.Client;
import com.pascalarvee.banking.service.ClientService;

/**
 * @author PASCAL
 *
 */

@Controller
public class ProfileController { /**User will be able to view and update his/her profile*/
	
	@Autowired
	private ClientService clientService;
	
	@RequestMapping("/viewProfile/{userId}")
	public String viewProfile(@PathVariable("userId")String userId, Model model){
		
		Client client = clientService.getClientByID(Integer.valueOf(userId));
		model.addAttribute("user", client);
		
		return "profile";
	}
}
