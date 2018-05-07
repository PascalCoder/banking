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

import com.pascalarvee.banking.domain.Client;
import com.pascalarvee.banking.service.ClientService;

/**
 * @author PASCAL
 *
 */

@RestController
@RequestMapping("/rest")
public class RESTFullController {
	
	@Autowired
	private ClientService clientService;
	
	//@ResponseBody
	@RequestMapping(value="/users", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ArrayList<Client> getAllClients(){
		
		ArrayList<Client> clients = new ArrayList<>(clientService.getAllClients());
		
		return clients;
	}
	
	//@ResponseBody
	@RequestMapping(value="/users/{firstName}", method=RequestMethod.GET)
	public ArrayList<Client> getClientsByFirstName(@PathVariable("firstName")String firstName){
		ArrayList<Client> clients = (ArrayList<Client>) clientService.getClientsByFirstName(firstName);
		
		return clients;
	}

	@ResponseBody
	@RequestMapping(value="/users/byLastName/{lastName}", method=RequestMethod.GET) /**/
	public ArrayList<Client> getClientsByLastName(@PathVariable("lastName")String lastName){
		ArrayList<Client> clients = (ArrayList<Client>) clientService.getClientsByLastName(lastName);
		
		return clients;
	}
	
	@RequestMapping(value="/user/updateInfo/{username}", method=RequestMethod.PUT)
	public boolean updateClientInfo(@PathVariable("username")String username, @RequestBody Client client){
		System.out.println("Username: " + username);
		System.out.println("Username: " + client.getUsername());
		
		return true;
	}
}
