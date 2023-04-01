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
import org.springframework.web.bind.annotation.RestController;

import com.vinay.model.InsurancePolicy;
import com.vinay.service.InsurancePolicyService;

@RestController
@RequestMapping("/api/policies/")
public class InsurancePolicyController {
	
	@Autowired
	private InsurancePolicyService insurancePolicyService;
	
	
	@PostMapping("/{ClientId}")
	public ResponseEntity<InsurancePolicy> createdInsurancePolicy(@RequestBody InsurancePolicy insurancePolicy, @PathVariable("ClientId") Integer ClientId){
		return new ResponseEntity<InsurancePolicy>(insurancePolicyService.createNewInsurancePolicy(ClientId,insurancePolicy),HttpStatus.CREATED);
	}
	
	
	
	@PutMapping("/{id}")
	public ResponseEntity<InsurancePolicy> updateInsurancePolicy(@RequestBody InsurancePolicy insurancePolicy, @PathVariable("id") Integer id){
		return new ResponseEntity<InsurancePolicy>(insurancePolicyService.updateInsurancePolcy(insurancePolicy, id),HttpStatus.OK);
	}

	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteInsurancePolicy( @PathVariable("id") Integer id){
	return new ResponseEntity<String>(insurancePolicyService.deleteInsurancePolicy(id),HttpStatus.OK);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<InsurancePolicy> getInsurancePolicy(@PathVariable("id") Integer id){
		return new ResponseEntity<InsurancePolicy>(insurancePolicyService.getById(id),HttpStatus.OK);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<InsurancePolicy>> getAllInsurancePolicy(){
		return new ResponseEntity<List<InsurancePolicy>>(insurancePolicyService.getAllInsurancePolicy(),HttpStatus.OK);
	}
	
	
//	@PutMapping("/{clientId}/{policyId}")
//	public ResponseEntity<InsurancePolicy> assignInsurancePolicy(@PathVariable("clientId") Integer clientId,@PathVariable("policyId") Integer policyId){
//		return new ResponseEntity<InsurancePolicy>(insurancePolicyService.assignPolicyWithUser(clientId, policyId),HttpStatus.OK);
//	}

//	@PutMapping("/")
//	public ResponseEntity<InsurancePolicy> assignInsurancePolicy(){
//		return new ResponseEntity<InsurancePolicy>(insurancePolicyService.assignPolicyWithUser(1,1),HttpStatus.OK);
//	}

	

}
