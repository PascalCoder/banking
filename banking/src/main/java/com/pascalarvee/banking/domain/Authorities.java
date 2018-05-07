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
public class Authorities {
	
	@Id
	@GeneratedValue
	@Column(name="AUTHORITIES_ID")
	private Integer authoritiesId;
	
	@Column
	private String username;
	
	@Column
	private String authority;
	
	public Integer getAuthoritiesId() {
		return authoritiesId;
	}
	public void setAuthoritiesId(Integer authoritiesId) {
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
