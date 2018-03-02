/**
 * 
 */
package com.pascalarvee.banking.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author PASCAL
 *
 */

@Entity
public class Authorities {
	
	@Id
	@GeneratedValue
	private String authoritiesId;
	private String username;
	private String authority;
	
	public String getAuthoritiesId() {
		return authoritiesId;
	}
	public void setAuthoritiesId(String authoritiesId) {
		this.authoritiesId = authoritiesId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	
	
	

}
