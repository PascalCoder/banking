/**
 * 
 */
package com.pascalarvee.banking.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

//import org.joda.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author PASCAL
 *
 */

@Entity
@Inheritance
@DiscriminatorColumn(name="TRANSACTION_TYPE")
public class Transaction implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8158574973504737128L;
	
	@Id
	@GeneratedValue
	private String transactionId;
	
	@Enumerated(EnumType.STRING)
	private TransactionType transactionType;
	
	@ManyToOne
	@JoinColumn(name="userId")
	private User user;
	
	@ManyToOne
	@JoinColumn(name="accountId")
	private BankAccount bankAccount;
	
	private BigDecimal amount;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
	private java.time.LocalDateTime transactionDate;
	private String description;
	
	public String getTransactionId() {
		return transactionId;
	}
	
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	
	public TransactionType getTransactionType() {
		return transactionType;
	}
	
	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public BankAccount getBankAccount() {
		return bankAccount;
	}
	
	public void setBankAccount(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}
	
	public BigDecimal getAmount() {
		return amount;
	}
	
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	
	public java.time.LocalDateTime getTransactionDate() {
		return transactionDate;
	}
	
	public void setTransactionDate(java.time.LocalDateTime transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
