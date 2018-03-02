/**
 * 
 */
package com.pascalarvee.banking.domain;

import java.io.Serializable;
import java.util.List;
//import java.util.Set;

import javax.persistence.CascadeType;
//import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * @author PASCAL
 *
 */

@Entity
@JsonIgnoreProperties({"userId","password","bankAccounts","transactions","recipients","receivingAccounts"}) /*"address",*/
@JsonPropertyOrder({"firstName","middleName","lastName","gender","DOB","email","phoneNumber","username"})
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1122051521728784115L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String userId;
	
	@JsonProperty("first_name")
	@NotEmpty
	@Pattern(regexp="[^0-9]*")
	private String firstName;
	
	@JsonProperty("middle_name")
	@Valid
	@Pattern(regexp="[^0-9]*")
	private String middleName;
	
	@JsonProperty("last_name")
	@NotEmpty
	@Pattern(regexp="[^0-9]*")
	private String lastName;
	
	private String gender;
	
	@Valid
	@OneToOne
	private Address address;
	
	@Email
	private String email;
	
	@JsonProperty("DOB")
	//@Past
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	//@NotNull
	//@Temporal(TemporalType.DATE)
	private java.time.LocalDate dateOfBirth;
	
	@JsonProperty("phone_number")
	private String phoneNumber;
	
	/*@NotEmpty(message="Please provide a username.")*/
	@Size(min=4, max=20)
	private String username;
	
	/*@NotEmpty(message="Please enter a password.")*/
	@Size(min=4, max=30)
	private String password;
	
	@Transient
	private String passwordConfirm;
	
	private boolean enabled;
	
	//@ElementCollection
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy="user", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private List<BankAccount> bankAccounts;
	
	//@ElementCollection
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy="user", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<Transaction> transactions;
	
	//@ElementCollection
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY) /*mappedBy="user", */
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<User> recipients;
	
	//@ElementCollection
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY) /*mappedBy="user", */
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<BankAccount> receivingAccounts;
	
	public User(){}
	
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public java.time.LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(java.time.LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public List<BankAccount> getBankAccounts() {
		return bankAccounts;
	}

	public void setBankAccounts(List<BankAccount> bankAccounts) {
		this.bankAccounts = bankAccounts;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	/**
	 * @return the recipients
	 */
	public List<User> getRecipients() {
		return recipients;
	}

	/**
	 * @param recipients the recipients to set
	 */
	public void setRecipients(List<User> recipients) {
		this.recipients = recipients;
	}

	/**
	 * @return the receivingAccounts
	 */
	public List<BankAccount> getReceivingAccounts() {
		return receivingAccounts;
	}

	/**
	 * @param receivingAccounts the receivingAccounts to set
	 */
	public void setReceivingAccounts(List<BankAccount> receivingAccounts) {
		this.receivingAccounts = receivingAccounts;
	}
	
}
