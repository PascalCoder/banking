/**
 * 
 */
package com.pascalarvee.banking.domain;

/**
 * @author PASCAL
 *
 */
public enum TransactionType {
	
	DEPOSIT("Deposit"), WITHDRAWAL("Withdrawal"), TRANSFER("Transfer");
	
	private String transactionType;
	
	private TransactionType(String transactionType){
		this.transactionType = transactionType;
	}
	
	@Override
	public String toString(){
		return this.transactionType;
	}
}
