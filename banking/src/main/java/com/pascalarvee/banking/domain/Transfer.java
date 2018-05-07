/**
 * 
 */
package com.pascalarvee.banking.domain;

import javax.persistence.Entity;
import javax.persistence.Transient;

/**
 * @author PASCAL
 *
 */

@Entity
public class Transfer extends Transaction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5858187836394507236L;
	
	@Transient
	private Client sender;
	
	@Transient
	private Client receiver;
	
	@Transient
	private BankAccount sendingAccount;
	
	@Transient
	private BankAccount receivingAccount;
	
	//@Column(name="ACCT_TYPE")
	private static final String ACCOUNT_TYPE = TransactionType.TRANSFER.toString();
	
	public Client getSender() {
		return sender;
	}
	
	public void setSender(Client sender) {
		this.sender = sender;
	}
	
	public Client getReceiver() {
		return receiver;
	}
	
	public void setReceiver(Client receiver) {
		this.receiver = receiver;
	}
	
	public BankAccount getSendingAccount() {
		return sendingAccount;
	}
	
	public void setSendingAccount(BankAccount sendingAccount) {
		this.sendingAccount = sendingAccount;
	}
	
	public BankAccount getReceivingAccount() {
		return receivingAccount;
	}
	
	public void setReceivingAccount(BankAccount receivingAccount) {
		this.receivingAccount = receivingAccount;
	}
	
	public static String getAccountType() {
		return ACCOUNT_TYPE;
	}
	
}
