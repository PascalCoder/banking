package com.pascalarvee.banking.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pascalarvee.banking.dao.UserDAO;
import com.pascalarvee.banking.domain.User;
import com.pascalarvee.banking.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDAO userDAO;

	@Override
	public User getUserByCredentials(String username, String password) {
		
		return userDAO.getUserByCredentials(username, password);
	}

	@Override
	public User getUserByID(String userId) {
		
		return userDAO.getUserByID(userId);
	}

	@Override
	public List<User> getAllUsers() {
		
		return userDAO.getAllUsers();
	}

	@Override
	public void addUser(User user) {
		
		userDAO.addUser(user);
	}

	@Override
	public void desactivateUser(String userId) {
		
		userDAO.desactivateUser(userId);
	}

	@Override
	public User getUserByUsername(String username) {
		
		return userDAO.getUserByUsername(username);
	}

	@Override
	public List<User> getUsersByFirstName(String firstName) {
		
		return userDAO.getUsersByFirstName(firstName);
	}

	@Override
	public List<User> getUsersByLastName(String lastName) {
		
		return userDAO.getUsersByLastName(lastName);
	}

}
