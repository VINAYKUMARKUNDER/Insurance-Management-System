package com.vinay.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.vinay.dto.ClientDto;


@Service
public class ClientUserDetailsService implements UserDetailsService{
	
	
	@Autowired
	private ClientService clientService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		ClientDto client = clientService.findByEmail(username);
		
		List<GrantedAuthority> authority = new ArrayList<>();
		
		return new User(client.getEmail(), client.getPassword(), authority);
		
	}

}
