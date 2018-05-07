/**
 * 
 */
package com.pascalarvee.banking.dao;

import java.util.List;

import com.pascalarvee.banking.domain.Client;

/**
 * @author PASCAL
 *
 */
public interface ClientDAO {
	
	Client getClientByCredentials(String username, String password);
	
	Client getClientByUsername(String username);
	
	Client getClientByID(Integer userId);
	
	List<Client> getAllClients();
	
	void addClient(Client client);
	
	void desactivateClient(Integer userId);
	
	void updateClientProfile(Client client);
	
	List<Client> getClientsByFirstName(String firstName);
	
	List<Client> getClientsByLastName(String lastName);
}
