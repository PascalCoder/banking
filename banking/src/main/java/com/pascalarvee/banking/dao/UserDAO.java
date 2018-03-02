/**
 * 
 */
package com.pascalarvee.banking.dao;

import java.util.List;

import com.pascalarvee.banking.domain.User;

/**
 * @author PASCAL
 *
 */
public interface UserDAO {
	
	User getUserByCredentials(String username, String password);
	
	User getUserByUsername(String username);
	
	User getUserByID(String userId);
	
	List<User> getAllUsers();
	
	void addUser(User user);
	
	void desactivateUser(String userId);
	
	void updateUserProfile(User user);
	
	List<User> getUsersByFirstName(String firstName);
	
	List<User> getUsersByLastName(String lastName);
}
