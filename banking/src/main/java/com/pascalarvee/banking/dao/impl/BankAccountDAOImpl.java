package com.pascalarvee.banking.dao.impl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pascalarvee.banking.dao.BankAccountDAO;
import com.pascalarvee.banking.dao.ClientDAO;
import com.pascalarvee.banking.domain.BankAccount;
import com.pascalarvee.banking.domain.Transaction;
import com.pascalarvee.banking.domain.Client;

@Repository
@Transactional
public class BankAccountDAOImpl implements BankAccountDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private ClientDAO clientDAO;

	@Override
	public void addBankAccount(Integer clientId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addTransaction(BankAccount bankAccount, Transaction transaction) {
		// TODO Auto-generated method stub

	}

	@Override
	public LinkedList<BankAccount> getBankAccountsByClient(Integer clientId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addTransactionRecipient(Integer clientId, String accountNumber) {
		
		Session session = sessionFactory.getCurrentSession();
		
		Client sender = clientDAO.getClientByID(clientId);
		BankAccount receivingAccount = getBankAccountByAccountNumber(accountNumber);
		//Transaction transfer = new Transfer();
		
		Client recipient = receivingAccount.getClient();
		System.out.println("Recipient: " + recipient.getEmail());
		
		List<Client> recipients = sender.getRecipients();
		recipients.add(recipient);
		System.out.println("Recipients: " + new ArrayList<>(recipients).get(0).getEmail());
		
		List<BankAccount> receivingAccounts = sender.getReceivingAccounts();
		receivingAccounts.add(receivingAccount);
		System.out.println("ReceivingAccounts: " + new ArrayList<>(receivingAccounts).get(0).getAccountDescription() + " "); 
		
		session.saveOrUpdate(sender);
		session.flush();

	}

	@Override
	public BankAccount getBankAccountByAccountNumber(String accountNumber) {
		
		Session session = sessionFactory.getCurrentSession();
		
		Query query = session.createQuery("from BankAccount where accountNumber=?");
		query.setString(0, accountNumber);
				
		return (BankAccount)query.uniqueResult();
	}

}
