/**
 * 
 */
package com.pascalarvee.banking.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
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
	@Column(name="TRANSACTION_ID")
	private Integer transactionId;
	
	@Enumerated(EnumType.STRING)
	@Column(name="T_TYPE")
	private TransactionType transactionType;
	
	@ManyToOne
	@JoinColumn(name="CLIENT_ID")
	//@Column(name="USER_ID")
	private Client client;
	
	@ManyToOne
	@JoinColumn(name="ACCOUNT_ID")
	//@Column(name="ACCOUNT_ID")
	private BankAccount bankAccount;
	
	@Column
	private BigDecimal amount;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
	@Column(name="TRANSACTION_DATE")
	private java.time.LocalDateTime transactionDate;
	
	@Column
	private String description;
	
	public Integer getTransactionId() {
		return transactionId;
	}
	
	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
	}
	
	public TransactionType getTransactionType() {
		return transactionType;
	}
	
	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}
	
	public Client getClient() {
		return client;
	}
	
	public void setClient(Client client) {
		this.client = client;
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
