/**
 * 
 */
package com.pascalarvee.banking.domain;

/**
 * @author PASCAL
 *
 */
public enum Gender {

	MALE("Male"), FEMALE("Female");
	
	String gender;
	
	Gender(String gender){
		this.gender = gender;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	@Override
	public String toString(){
		return this.gender;
	}
}
