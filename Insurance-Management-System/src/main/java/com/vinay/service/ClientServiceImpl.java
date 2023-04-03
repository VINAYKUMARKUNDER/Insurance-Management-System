package com.vinay.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.vinay.dto.ClientDto;
import com.vinay.exception.ResourceNotFoundException;
import com.vinay.model.Client;
import com.vinay.repository.ClientRepository;

@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public ClientDto addClient(ClientDto client) {
		if (LocalDate.now().isBefore(client.getDateOfBirth()))
			throw new ResourceNotFoundException("Date is not valid plese provide past date...");
		Client clientData = modelMapper.map(client, Client.class);
		clientData.setPassword(passwordEncoder.encode(clientData.getPassword()));
		Client savedClient = clientRepository.save(clientData);
		return modelMapper.map(savedClient, ClientDto.class);
	}

	@Override
	public ClientDto findById(Integer id) {
		Client client = clientRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Client ", "clientId", "" + id));
		return modelMapper.map(client, ClientDto.class);
	}

	@Override
	public ClientDto findByEmail(String email) {
		Client client = clientRepository.findByEmail(email)
				.orElseThrow(() -> new ResourceNotFoundException("Client", "client email", email));
		return modelMapper.map(client, ClientDto.class);
	}

	@Override
	public List<ClientDto> findAllClient() {
		List<Client> clients = clientRepository.findAll();
		List<ClientDto> clientsDto = clients.stream().map(client -> modelMapper.map(client, ClientDto.class))
				.collect(Collectors.toList());
		return clientsDto;
	}

	@Override
	public ClientDto updateClientInfo(ClientDto client, Integer clientId) {
		if (client.getEmail() != null)
			throw new ResourceNotFoundException("email not changeble plese remove email in json data...");

		Client prevClient = clientRepository.findById(clientId)
				.orElseThrow(() -> new ResourceNotFoundException("Client ", "clientId", "" + clientId));
		Client updatedClient = modelMapper.map(client, Client.class);
		updatedClient.setId(clientId);
		updatedClient.setEmail(prevClient.getEmail());
		updatedClient.setPassword(passwordEncoder.encode(updatedClient.getPassword()));
		Client updatedClientdata = clientRepository.save(updatedClient);
		return modelMapper.map(updatedClientdata, ClientDto.class);
	}

	@Override
	public String deleteClient(Integer id) {
		Client client = clientRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Client ", "clientId", "" + id));
		clientRepository.delete(client);

		return "Client Data deleted successfully...";

	}

}
