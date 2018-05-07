/**
 * 
 */
package com.pascalarvee.banking.service;

import java.util.List;

import com.pascalarvee.banking.domain.Client;

/**
 * @author PASCAL
 *
 */

public interface ClientService {

	Client getClientByCredentials(String username, String password);
	
	Client getClientByUsername(String username);

	Client getClientByID(Integer clientId);

	List<Client> getAllClients();

	void addClient(Client client);

	void desactivateClient(Integer clientId);
	
	List<Client> getClientsByFirstName(String firstName);
	
	List<Client> getClientsByLastName(String lastName);
}
