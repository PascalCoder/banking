package com.pascalarvee.banking.dao.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pascalarvee.banking.dao.TransactionDAO;
import com.pascalarvee.banking.domain.BankAccount;
import com.pascalarvee.banking.domain.Transaction;
import com.pascalarvee.banking.domain.TransactionType;
import com.pascalarvee.banking.domain.Transfer;
import com.pascalarvee.banking.domain.User;

@Repository
@Transactional
public class TransactionDAOImpl implements TransactionDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addTransaction(Transaction transaction) {
		Session session = sessionFactory.getCurrentSession();
		
		User user = transaction.getUser();
		BankAccount bankAccount = transaction.getBankAccount();
		TransactionType transactionType = transaction.getTransactionType();
		transaction.setTransactionDate(LocalDateTime.parse((LocalDateTime.now()).toString().substring(0,19), DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")));
		
		System.out.println("Transaction Type: " + transaction.getTransactionType());
		if(transactionType.equals(TransactionType.DEPOSIT)){
			bankAccount.setBalance(bankAccount.getBalance().add(transaction.getAmount()));
			//System.out.println("Add " + bankAccount.getBalance().add(transaction.getAmount()));
			transaction.setDescription("This is a deposit of $" + transaction.getAmount() + " made on " + transaction.getTransactionDate());
		} else if(transactionType.equals(TransactionType.WITHDRAWAL)){
			bankAccount.setBalance(bankAccount.getBalance().subtract(transaction.getAmount()));
			transaction.setDescription("This is a withdrawal of $" + transaction.getAmount() + " made on " + transaction.getTransactionDate());
		}
		
		bankAccount.getTransactions().add(transaction);
		
		user.getBankAccounts().add(bankAccount); //Maybe we should remove the bankAccount with the same ID before adding this one
		
		session.saveOrUpdate(user);
		session.saveOrUpdate(bankAccount);
		session.saveOrUpdate(transaction);
		
		session.flush();

	}
	
	@Override
	public void addTransfer(Transfer transfer) {
		Session session = sessionFactory.getCurrentSession();
		
		User sender = transfer.getSender();
		User receiver = transfer.getReceiver();
		
		transfer.setUser(sender);
		
		BankAccount sendingAccount = transfer.getSendingAccount();
		BankAccount receivingAccount = transfer.getReceivingAccount();
		
		transfer.setTransactionType(TransactionType.TRANSFER);
		transfer.setTransactionDate(LocalDateTime.parse((LocalDateTime.now()).toString().substring(0,19), DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")));
		sendingAccount.setBalance(sendingAccount.getBalance().subtract(transfer.getAmount()));
		receivingAccount.setBalance(receivingAccount.getBalance().add(transfer.getAmount()));
		transfer.setDescription("This is a transfer of $" + transfer.getAmount() + " from "
				+ sender.getFirstName() + " " + sender.getLastName() + " to "
				+ receiver.getFirstName() + " " + receiver.getLastName());
		
		sendingAccount.getTransactions().add(transfer);
		receivingAccount.getTransactions().add(transfer);
		
		sender.getBankAccounts().add(sendingAccount);
		receiver.getBankAccounts().add(receivingAccount);
		
		/*session.saveOrUpdate(sender);*/
		/*session.saveOrUpdate(receiver);*/
		session.saveOrUpdate(sendingAccount);
		session.saveOrUpdate(receivingAccount);
		session.saveOrUpdate(transfer);
		
		session.flush();
		
	}

	@Override
	public Set<Transaction> getTransactionsByUser(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Transaction> getTransactionsByBankAccount(String accountId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Transaction> getTransactionsByDates(LocalDate startDate, LocalDate endDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Transaction getTransactionById(String transactionId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void cancelTransaction(String transactionId) {
		// TODO Auto-generated method stub

	}

}
