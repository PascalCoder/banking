package com.pascalarvee.banking.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pascalarvee.banking.dao.ClientDAO;
import com.pascalarvee.banking.domain.Client;
import com.pascalarvee.banking.service.ClientService;

@Service
public class ClientServiceImpl implements ClientService {
	
	@Autowired
	private ClientDAO clientDAO;

	@Override
	public Client getClientByCredentials(String username, String password) {
		
		return clientDAO.getClientByCredentials(username, password);
	}

	@Override
	public Client getClientByID(Integer clientId) {
		
		return clientDAO.getClientByID(clientId);
	}

	@Override
	public List<Client> getAllClients() {
		
		return clientDAO.getAllClients();
	}

	@Override
	public void addClient(Client client) {
		
		clientDAO.addClient(client);
	}

	@Override
	public void desactivateClient(Integer clientId) {
		
		clientDAO.desactivateClient(clientId);
	}

	@Override
	public Client getClientByUsername(String username) {
		
		return clientDAO.getClientByUsername(username);
	}

	@Override
	public List<Client> getClientsByFirstName(String firstName) {
		
		return clientDAO.getClientsByFirstName(firstName);
	}

	@Override
	public List<Client> getClientsByLastName(String lastName) {
		
		return clientDAO.getClientsByLastName(lastName);
	}

}
