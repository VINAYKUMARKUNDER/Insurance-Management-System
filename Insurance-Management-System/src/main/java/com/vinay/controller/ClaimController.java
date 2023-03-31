package com.vinay.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vinay.model.Claim;
import com.vinay.service.ClaimService;

@RestController
@RequestMapping("/api/claims/")
public class ClaimController {
	
	@Autowired
	private ClaimService claimService;
	
	
	@GetMapping("/")
	public ResponseEntity<List<Claim>> getAllClaims(){
		List<Claim> allClaim = claimService.getAllClaim();
		return new ResponseEntity<List<Claim>>(allClaim, HttpStatus.OK);
	}

}
