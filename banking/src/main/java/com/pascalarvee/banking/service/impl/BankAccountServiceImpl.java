package com.pascalarvee.banking.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pascalarvee.banking.dao.BankAccountDAO;
import com.pascalarvee.banking.domain.BankAccount;
import com.pascalarvee.banking.service.BankAccountService;

@Service
public class BankAccountServiceImpl implements BankAccountService {
	
	@Autowired
	private BankAccountDAO bankAccountDAO;

	@Override
	public void addTransactionRecipient(String userId, String accoountNumber) {
		
		bankAccountDAO.addTransactionRecipient(userId, accoountNumber);

	}

	@Override
	public BankAccount getBankAccountByAccountNumber(String accountNumber) {
		
		return bankAccountDAO.getBankAccountByAccountNumber(accountNumber);
	}

}
