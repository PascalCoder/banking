/**
 * 
 */
package com.pascalarvee.banking.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pascalarvee.banking.domain.User;
import com.pascalarvee.banking.service.UserService;

/**
 * @author PASCAL
 *
 */

@RestController
@RequestMapping("/rest")
public class RESTFullController {
	
	@Autowired
	private UserService userService;
	
	//@ResponseBody
	@RequestMapping(value="/users", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ArrayList<User> getAllUsers(){
		
		ArrayList<User> users = new ArrayList<>(userService.getAllUsers());
		
		return users;
	}
	
	//@ResponseBody
	@RequestMapping(value="/users/{firstName}", method=RequestMethod.GET)
	public ArrayList<User> getUsersByFirstName(@PathVariable("firstName")String firstName){
		ArrayList<User> users = (ArrayList<User>) userService.getUsersByFirstName(firstName);
		
		return users;
	}

	@ResponseBody
	@RequestMapping(value="/users/byLastName/{lastName}", method=RequestMethod.GET) /**/
	public ArrayList<User> getUsersByLastName(@PathVariable("lastName")String lastName){
		ArrayList<User> users = (ArrayList<User>) userService.getUsersByLastName(lastName);
		
		return users;
	}
	
	@RequestMapping(value="/user/updateInfo/{username}", method=RequestMethod.PUT)
	public boolean updateUserInfo(@PathVariable("username")String username, @RequestBody User user){
		System.out.println("Username: " + username);
		System.out.println("Username: " + user.getUsername());
		
		return true;
	}
}
