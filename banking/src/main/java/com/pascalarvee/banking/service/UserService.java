/**
 * 
 */
package com.pascalarvee.banking.service;

import java.util.List;

import com.pascalarvee.banking.domain.User;

/**
 * @author PASCAL
 *
 */

public interface UserService {

	public User getUserByCredentials(String username, String password);
	
	public User getUserByUsername(String username);

	public User getUserByID(String userId);

	public List<User> getAllUsers();

	public void addUser(User user);

	public void desactivateUser(String userId);
	
	List<User> getUsersByFirstName(String firstName);
	
	List<User> getUsersByLastName(String lastName);
}
