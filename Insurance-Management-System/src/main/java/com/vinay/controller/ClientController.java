package com.vinay.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vinay.model.Client;
import com.vinay.service.ClientService;

@RestController
@RequestMapping("/api/clients/")
public class ClientController {
	
	@Autowired
	private ClientService clientService;
	
	@PostMapping("/")
	public ResponseEntity<Client> createClient(@RequestBody Client client){
	return new ResponseEntity<Client>(clientService.addClient(client),HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Client> updateClient(@RequestBody Client client, @PathVariable("id") Integer id){
	return new ResponseEntity<Client>(clientService.updateClientInfo(client, id),HttpStatus.OK);
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteClient( @PathVariable("id") Integer id){
	return new ResponseEntity<String>(clientService.deleteClient(id),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Client> getClientById(@PathVariable("id") Integer id){
	return new ResponseEntity<Client>(clientService.findById(id),HttpStatus.OK);
	}
	
	@GetMapping("/email/")
	public ResponseEntity<Client> getClientByEmail(@RequestParam("email") String email){
	return new ResponseEntity<Client>(clientService.findByEmail(email),HttpStatus.OK);
	}
	
	
	@GetMapping("/")
	public ResponseEntity<List<Client>> getAllClient(){
	return new ResponseEntity<List<Client>>(clientService.findAllClient(),HttpStatus.OK);
	}
	


}
