package com.vinay.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;

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
import org.springframework.web.bind.annotation.RestController;

import com.vinay.dto.ClaimDto;
import com.vinay.model.Claim;
import com.vinay.service.ClaimService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/claims/")
public class ClaimController {
	
	@Autowired
	private ClaimService claimService;
	
	
	
	
	@PostMapping("/{id}")
	public ResponseEntity<Claim> createClaim(@PathVariable("id") Integer id,@Valid @RequestBody ClaimDto claim){
		return new ResponseEntity<Claim>(claimService.createNewClaim(id,claim),HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Claim> updateClaim(@RequestBody Claim claim,@PathVariable("id") Integer id){
		return new ResponseEntity<Claim>(claimService.updateClaim(claim, id),HttpStatus.OK);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Claim> getClaimById(@PathVariable("id") Integer id){
		return new ResponseEntity<Claim>(claimService.getClaimById(id), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteClaimById(@PathVariable("id") Integer id){
		return new ResponseEntity<String>(claimService.deleteClaim(id), HttpStatus.OK);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Claim>> getAllClaims(){
		return new ResponseEntity<List<Claim>>(claimService.getAllClaim(), HttpStatus.OK);
	}

}
