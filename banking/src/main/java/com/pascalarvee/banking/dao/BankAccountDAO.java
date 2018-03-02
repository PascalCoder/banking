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

	void addBankAccount(String userId);
	
	void addTransaction(BankAccount bankAccount, Transaction transaction);
	
	LinkedList<BankAccount> getBankAccountsByUser(String userId);
	
	void addTransactionRecipient(String userId, String accoountNumber);
	
	BankAccount getBankAccountByAccountNumber(String accountNumber);
}
