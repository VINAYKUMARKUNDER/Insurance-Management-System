package com.vinay.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vinay.exception.ResourceNotFoundException;
import com.vinay.model.Client;
import com.vinay.repository.ClientRepository;


@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public Client addClient(Client client) {
		return clientRepository.save(client);
	}

	@Override
	public Client findById(Integer id) {
		Client client = clientRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Client ", "clientId", "" + id));
		return client;
	}

	@Override
	public Client findByEmail(String email) {
		return clientRepository.findByEmail(email)
				.orElseThrow(() -> new ResourceNotFoundException("Client", "client email", email));
	}

	@Override
	public List<Client> findAllClient() {
		return clientRepository.findAll();
	}

	@Override
	public Client updateClientInfo(Client client, Integer clientId) {
		clientRepository.findById(clientId)
				.orElseThrow(() -> new ResourceNotFoundException("Client ", "clientId", "" + clientId));
		Client updatedClient = modelMapper.map(client, Client.class);
		updatedClient.setId(clientId);
		return clientRepository.save(updatedClient);
	}

	@Override
	public String deleteClient(Integer id) {
		Client client = clientRepository.findById(id)
		.orElseThrow(() -> new ResourceNotFoundException("Client ", "clientId", "" + id));
		clientRepository.delete(client);
		
		return "Client Data deleted successfully...";

	}

}
