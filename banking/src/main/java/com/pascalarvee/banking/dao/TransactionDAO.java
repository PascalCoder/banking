/**
 * 
 */
package com.pascalarvee.banking.dao;

import java.util.Set;

import org.joda.time.LocalDate;

import com.pascalarvee.banking.domain.Transaction;
import com.pascalarvee.banking.domain.Transfer;

/**
 * @author PASCAL
 *
 */
public interface TransactionDAO {
	
	void addTransaction(Transaction transaction);
	
	void addTransfer(Transfer transfer);
	
	Set<Transaction> getTransactionsByUser(String userId);
	
	Set<Transaction> getTransactionsByBankAccount(String accountId);
	
	Set<Transaction> getTransactionsByDates(LocalDate startDate, LocalDate endDate);
	
	Transaction getTransactionById(String transactionId);
	
	void cancelTransaction(String transactionId);
}
