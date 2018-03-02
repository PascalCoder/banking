/**
 * 
 */
package com.pascalarvee.banking.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
//import org.joda.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author PASCAL
 *
 */

@Entity
@Inheritance
@DiscriminatorColumn(name = "ACCT_TYPE")
public class BankAccount implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6760517714029904672L;

	@Id
	@GeneratedValue
	private String accountId;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
	private java.time.LocalDateTime dateOpened;
	
	private String accountNumber;
	private String routingNumber;
	private static String accountType;
	private static double interestRate;
	private String accountDescription;

	@ManyToOne
	@JoinColumn(name = "userId")
	private User user;

	private BigDecimal balance;
	
	//@ElementCollection
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "bankAccount", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Transaction> transactions;
	
	/*public BankAccount(){
		
	}*/

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public java.time.LocalDateTime getDateOpened() {
		return dateOpened;
	}

	public void setDateOpened(java.time.LocalDateTime dateOpened) {
		this.dateOpened = dateOpened;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getRoutingNumber() {
		return routingNumber;
	}

	public void setRoutingNumber(String routingNumber) {
		this.routingNumber = routingNumber;
	}

	public String getAccountType() {
		return accountType;
	}

	/*
	 * public void setAccountType(String accountType) { this.accountType =
	 * accountType; }
	 */

	public User getUser() {
		return user;
	}

	public double getInterestRate() {
		return interestRate;
	}

	/*
	 * public void setInterestRate(double interestRate) { this.interestRate =
	 * interestRate; }
	 */

	public void setUser(User user) {
		this.user = user;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	public String getAccountDescription() {
		
		String accountLastDigits = this.accountNumber.substring(8);
		this.accountDescription = "Banksys " + this.getAccountType() + " - " + accountLastDigits;
		
		return accountDescription;
	}

	public void setAccountDescription(String accountDescription) {
		this.accountDescription = accountDescription;
	}

}
