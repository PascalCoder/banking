/**
 * 
 */
package com.pascalarvee.banking.domain;

import java.math.BigDecimal;

import javax.persistence.Entity;

/**
 * @author PASCAL
 *
 */

@Entity
public class CheckingAccount extends BankAccount{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4139574200562017161L;
	
	/*private String checkingAccountId;*/
	private static final String ACCOUNT_TYPE = "Checking";
	private static final double INTEREST_RATE = 0.01;
	
	public CheckingAccount(){
		super();
		this.setBalance(new BigDecimal(100.0));
	}
	
	public String getAccountType() {
		return ACCOUNT_TYPE;
	}
	
	/*public void setAccountType(String accountType){		
		super.setAccountType(ACCOUNT_TYPE);
	}*/
	
	public double getInterestRate() {
		return INTEREST_RATE;
	}
	
	/*public void setInterestRate(double interestRate){
		super.setInterestRate(INTEREST_RATE);
	}*/
	
	/*public String getCheckingAccountId() {
		return checkingAccountId;
	}
	public void setCheckingAccountId(String checkingAccountId) {
		this.checkingAccountId = checkingAccountId;
	}*/
	
	
}
