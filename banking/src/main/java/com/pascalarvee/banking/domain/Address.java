/**
 * 
 */
package com.pascalarvee.banking.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * @author <a href="mailto:pascal.arvee@gmail.com">PASCAL ARVEE</a>
 *
 */

@JsonIgnoreProperties({"addressId","user"})
@JsonPropertyOrder({"addressLine1","addressLine2","city","state","country","zipCode"})
@Entity
public class Address implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -25970234942435478L;
	
	@Id
	@GeneratedValue
	@Column(name="ADDRESS_ID")
	private Integer addressId; /** Changed from String to Integer May 5 2018 */
	
	@NotEmpty
	@JsonProperty("address_line1")
	@Column(name="ADDRESS_LINE1")
	private String addressLine1;
	
	@JsonProperty("address_line2")
	@Column(name="ADDRESS_LINE2")
	private String addressLine2;
	
	@NotEmpty
	@Column(name="CITY")
	private String city;
	
	@Column(name="STATE")
	private String state;
	
	@NotEmpty
	@Column(name="COUNTRY")
	private String country;
	
	@JsonProperty("zip_code")
	@Column(name="ZIP_CODE")
	private String zipCode;
	
	/** Decided to drop this as it makes deleting a user more difficult. (May 5 2018)*/
	/*@OneToOne
	@JoinColumn(name="userId")
	@Column(name="USER_ID")    
	private User user;*/

	public Integer getAddressId() {
		return addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	/*public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}*/

	@Override
	public String toString() {
		return "Address [addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2 + ", city=" + city
				+ ", state=" + state + ", country=" + country + ", zipCode=" + zipCode + "]";
	}
	
}
