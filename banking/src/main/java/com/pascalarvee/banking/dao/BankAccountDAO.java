/**
 * 
 */
package com.pascalarvee.banking.dao;

import java.util.LinkedList;

import com.pascalarvee.banking.domain.BankAccount;
import com.pascalarvee.banking.domain.Transaction;

/**
 * @author PASCAL
 *
 */
public interface BankAccountDAO {

	void addBankAccount(Integer clientId);
	
	void addTransaction(BankAccount bankAccount, Transaction transaction);
	
	LinkedList<BankAccount> getBankAccountsByClient(Integer clientId);
	
	void addTransactionRecipient(Integer clientId, String accoountNumber);
	
	BankAccount getBankAccountByAccountNumber(String accountNumber);
}
