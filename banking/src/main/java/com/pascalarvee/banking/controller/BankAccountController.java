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
import com.pascalarvee.banking.domain.Client;
import com.pascalarvee.banking.service.BankAccountService;
import com.pascalarvee.banking.service.ClientService;

//import org.hibernate.dialect.PostgreSQLDialect;

/**
 * @author PASCAL
 *
 */

@Controller
public class BankAccountController { /**User will be able to add a new account (checking or savings)*/
	
	@Autowired
	private ClientService clientService;
	
	@Autowired
	private BankAccountService bankAccountService;
	
	Client client;
	BankAccount bankAccount;
	Transaction transaction;
	String accountNumber;
	
	@RequestMapping("/addAccount")
	public String addAccount(Model model){ //calculus 2 practice final exam with solutions
		
		return "addAccount";
	}
	
	@RequestMapping(value = "/addAccount", method=RequestMethod.POST)
	public String addAccountPost(@Valid Model model, @ModelAttribute("user")Client client){
		
		return "newAccountSuccess";
	}
	
	@RequestMapping("/bankAccount/{userId}")
	public String showDetails(@PathVariable("userId")String userId, Model model){
		
		Client client = clientService.getClientByID(Integer.valueOf(userId));
		
		model.addAttribute("user", client);
		
		return "accountDetails";
	}
	
	@RequestMapping(value="/addRecipient/{userId}", method=RequestMethod.GET)
	public String addRecipient(@PathVariable("userId")String userId, Model model){
		
		client = clientService.getClientByID(Integer.valueOf(userId));
		
		model.addAttribute("user", client);
		
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
		
		Client receiver = bankAccount.getClient();
		System.out.println("Receiver: " + receiver.getFirstName() + " " + receiver.getLastName());
		
		bankAccountService.addTransactionRecipient(client.getClientId(), accountNumber);	
		
		return "redirect:transaction/transfer/" + client.getClientId() + "?accountType=checking";
	}
}
