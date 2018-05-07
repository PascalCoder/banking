/**
 * 
 */
package com.pascalarvee.banking.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author PASCAL
 *
 */

@Entity
public class Users {
	
	@Id
	@GeneratedValue
	@Column(name="USERS_ID")
	private Integer usersId;
	
	@Column
	private String username;
	
	@Column
	private String password;
	
	@Column(name="CLIENT_ID")
	private Integer clientId;
	
	@Column
	private boolean enabled;
	
	public Integer getUsersId() {
		return usersId;
	}
	public void setUsersId(Integer usersId) {
		this.usersId = usersId;
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
	public Integer getClientId() {
		return clientId;
	}
	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	
	
}
