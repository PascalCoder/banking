/**
 * 
 */
package com.pascalarvee.banking.domain;

import javax.persistence.Entity;

/**
 * @author PASCAL
 *
 */

@Entity
public class SavingsAccount extends BankAccount{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4253254311279225118L;
	
	/*private String savingsAccountId;*/
	private static final String ACCOUNT_TYPE = "Savings";
	private static final double INTEREST_RATE = 0.015;
	
	public SavingsAccount(){
		super();
	}
	
	public String getAccountType() {
		return ACCOUNT_TYPE;
	}

	public double getInterestRate() {
		return INTEREST_RATE;
	}

	/*public String getSavingsAccountId() {
		return savingsAccountId;
	}

	public void setSavingsAccountId(String savingsAccountId) {
		this.savingsAccountId = savingsAccountId;
	}*/
	

}
