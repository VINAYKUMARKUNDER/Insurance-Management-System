package com.vinay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vinay.dto.ClientDto;
import com.vinay.service.ClientService;

import jakarta.validation.Valid;

@RestController
public class PublicController {
	
	@Autowired
	private ClientService clientService;
	
	@GetMapping("/signIn")
	public ResponseEntity<ClientDto>  getLoggedInClientDetailsHandler(Authentication auth ){
		
		ClientDto client = clientService.findByEmail(auth.getName());
		return new ResponseEntity<ClientDto>(client, HttpStatus.OK);
	}
	
	
	@GetMapping("/welcome")
	public String welcomeHandeler() {
		return "Welcome to Insurance manegement system";
	}
	
	
	@PostMapping("/register")
	public ResponseEntity<ClientDto> createClient(@Valid @RequestBody ClientDto client){
	return new ResponseEntity<ClientDto>(clientService.addClient(client),HttpStatus.CREATED);
	}

}
