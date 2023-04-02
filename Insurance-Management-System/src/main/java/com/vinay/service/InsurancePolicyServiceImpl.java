package com.vinay.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vinay.dto.InsurancePolicyDto;
import com.vinay.exception.ResourceNotFoundException;
import com.vinay.model.Client;
import com.vinay.model.InsurancePolicy;
import com.vinay.repository.InsurancePolicyRepository;

@Service
public class InsurancePolicyServiceImpl implements InsurancePolicyService {

	@Autowired
	private InsurancePolicyRepository insurancePolicyRepository;

	@Autowired
	private ClientService clientService;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public InsurancePolicy createNewInsurancePolicy(Integer clientId, InsurancePolicyDto insurancePolicy) {
		Client client = modelMapper.map(clientService.findById(clientId), Client.class);
		InsurancePolicy policy = modelMapper.map(insurancePolicy, InsurancePolicy.class);
		policy.setClient(client);
		return insurancePolicyRepository.save(policy);
	}

	@Override
	public InsurancePolicy getById(Integer insuId) {
		return insurancePolicyRepository.findById(insuId)
				.orElseThrow(() -> new ResourceNotFoundException("Insurance Policy", "policy ", "" + insuId));
	}

	@Override
	public InsurancePolicy updateInsurancePolcy(InsurancePolicyDto insurancePolicy, Integer insuId) {
		insurancePolicyRepository.findById(insuId)
				.orElseThrow(() -> new ResourceNotFoundException("Insurance Policy", "policy ", "" + insuId));
		InsurancePolicy newInsurance = modelMapper.map(insurancePolicy, InsurancePolicy.class);
		newInsurance.setId(insuId);
		return insurancePolicyRepository.save(newInsurance);
	}

	@Override
	public String deleteInsurancePolicy(Integer insuId) {
		InsurancePolicy insurancePolicy = insurancePolicyRepository.findById(insuId)
				.orElseThrow(() -> new ResourceNotFoundException("Insurance Policy", "policy ", "" + insuId));
		insurancePolicyRepository.delete(insurancePolicy);
		return "Insurance policy deleted successfully...";
	}

	@Override
	public List<InsurancePolicy> getAllInsurancePolicy() {
		return insurancePolicyRepository.findAll();
	}

	@Override
	public InsurancePolicy assignPolicyWithUser(Integer clientId, Integer policyId) {
		Client client =modelMapper.map(clientService.findById(clientId),Client.class);
		InsurancePolicyDto policy = modelMapper.map(getById(policyId),InsurancePolicyDto.class);
//		policy.setClient(client);
		return updateInsurancePolcy(policy, policyId);
	}

}
