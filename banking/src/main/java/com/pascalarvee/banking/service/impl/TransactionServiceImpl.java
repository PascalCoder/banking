package com.pascalarvee.banking.service.impl;

import java.util.Set;

import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pascalarvee.banking.dao.TransactionDAO;
import com.pascalarvee.banking.domain.Transaction;
import com.pascalarvee.banking.domain.Transfer;
import com.pascalarvee.banking.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {
	
	@Autowired
	private TransactionDAO transactionDAO;

	@Override
	public void addTransaction(Transaction transaction) {
		transactionDAO.addTransaction(transaction);
	}

	@Override
	public Set<Transaction> getTransactionsByClient(Integer clientId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Transaction> getTransactionsByBankAccount(Integer accountId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Transaction> getTransactionsByDates(LocalDate startDate, LocalDate endDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Transaction getTransactionById(Integer transactionId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void cancelTransaction(Integer transactionId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addTransfer(Transfer transfer) {
		
		transactionDAO.addTransfer(transfer);
		
	}

}
