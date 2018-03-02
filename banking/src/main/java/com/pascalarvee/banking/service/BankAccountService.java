/**
 * 
 */
package com.pascalarvee.banking.service;

import com.pascalarvee.banking.domain.BankAccount;

/**
 * @author PASCAL
 *
 */
public interface BankAccountService {

	void addTransactionRecipient(String userId, String accoountNumber);

	BankAccount getBankAccountByAccountNumber(String accountNumber);
}
