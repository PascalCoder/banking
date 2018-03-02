/**
 * 
 */
package com.pascalarvee.banking.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.pascalarvee.banking.domain.BankAccount;
import com.pascalarvee.banking.domain.Transaction;
import com.pascalarvee.banking.domain.TransactionType;
import com.pascalarvee.banking.domain.Transfer;
import com.pascalarvee.banking.domain.User;
import com.pascalarvee.banking.service.BankAccountService;
import com.pascalarvee.banking.service.TransactionService;
import com.pascalarvee.banking.service.UserService;

/**
 * @author PASCAL
 *
 */

@Controller
@RequestMapping("/transaction")
public class TransactionController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private TransactionService transactionService;
	
	@Autowired
	private BankAccountService bankAccountService;
	
	User user;
	BankAccount bankAccount;
	Transfer transaction; 
	

	@RequestMapping("/{transactionType}/{userId}") //will return a transaction form depending on the transactionType
	public String deposit(@PathVariable("transactionType")String transactionType, 
						  @PathVariable("userId")String userId, Model model,
						  @RequestParam("accountType")String accountType){
		
		user = userService.getUserByID(userId);
		model.addAttribute("user", user);
		//transaction.setUser(user);
		
		if(transactionType.equals("deposit")){
			return "depositForm";
		}else if(transactionType.equals("withdraw")){
			return "withdrawalForm";
		}else{
			LinkedList<BankAccount>bankAccounts =  new LinkedList<>();
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
			
			LinkedList<BankAccount> receivingAccounts = new LinkedList<>(user.getReceivingAccounts());
			List<User>recipientsSet = user.getRecipients();
			/*LinkedList<User> recipients = new LinkedList<>(recipientsSet);*/
			
			Transfer transaction = new Transfer();
			model.addAttribute("transfer", transaction);
			model.addAttribute("bankAccounts", bankAccounts);
			model.addAttribute("receivingAccounts", receivingAccounts);
			model.addAttribute("recipients", recipientsSet);
			
			return "transferForm";
		}
		
		
	}
	
	@RequestMapping(value = "/deposit", method=RequestMethod.POST)
	public String depositPost(@Valid Model model, @RequestParam("amount") String amount){ //@PathVariable("userId")String userId, , @ModelAttribute("transaction")Transaction transaction
		
		Transaction transaction = new Transaction();
		
		transaction.setTransactionType(TransactionType.DEPOSIT);
		transaction.setAmount(new BigDecimal(amount));
		transaction.setUser(user);
		
		
		List<BankAccount>bankAccounts = new ArrayList<>(user.getBankAccounts());
		
		BankAccount bankAccount = new BankAccount();
		for(BankAccount ba : bankAccounts){
			if(ba.getAccountType().equals("Checking")){
				bankAccount = ba; System.out.println("ba: " + ba.getAccountNumber());
				break;
			}
		}
		transaction.setBankAccount(bankAccount);
		
		transactionService.addTransaction(transaction);
		
		model.addAttribute("transaction", transaction);
		
		return "redirect:/default";
	}
	
	@RequestMapping(value = "/withdraw", method=RequestMethod.POST)
	public String withdrawalPost(@Valid Model model, @RequestParam("amount") String amount){ //@PathVariable("userId")String userId, , @ModelAttribute("transaction")Transaction transaction
		Transaction transaction = new Transaction();
		System.out.println("Inside withdraw: " + transaction.getTransactionType());
		transaction.setTransactionType(TransactionType.WITHDRAWAL);
		transaction.setAmount(new BigDecimal(amount));
		transaction.setUser(user);
		
		
		List<BankAccount>bankAccounts = new ArrayList<>(user.getBankAccounts());
		
		BankAccount bankAccount = new BankAccount();
		for(BankAccount ba : bankAccounts){
			if(ba.getAccountType().equals("Checking")){
				bankAccount = ba; System.out.println("ba: " + ba.getAccountNumber());
				break;
			}
		}
		transaction.setBankAccount(bankAccount);
		
		transactionService.addTransaction(transaction);
		
		model.addAttribute("transaction", transaction);
		
		return "redirect:/default";
	}
	
	@RequestMapping(value="/transfer", method=RequestMethod.POST)
	public String transfer(@RequestParam("sendingAccount") String sendingAccoount, 
						   @RequestParam("receivingAccount") String receivingAccount, 
						   @RequestParam("amount") String amount){ 
		
		Transfer transaction = new Transfer();
		
		transaction.setAmount(new BigDecimal(amount));
		transaction.setSender(user);
		transaction.setSendingAccount(bankAccountService.getBankAccountByAccountNumber(sendingAccoount));
		transaction.setReceivingAccount(bankAccountService.getBankAccountByAccountNumber(receivingAccount));
		transaction.setReceiver(transaction.getReceivingAccount().getUser());
		
		transactionService.addTransfer(transaction);
		
		return "redirect:/default";
	}
}
