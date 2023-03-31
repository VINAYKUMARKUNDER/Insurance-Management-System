package com.vinay.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.vinay.exception.ResourceNotFoundException;
import com.vinay.model.InsurancePolicy;
import com.vinay.repository.InsurancePolicyRepository;

public class InsurancePolicyServiceImpl implements InsurancePolicyService {
	
	@Autowired
	private InsurancePolicyRepository insurancePolicyRepository;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public InsurancePolicy createNewInsurancePolicy(InsurancePolicy insurancePolicy) {
		return insurancePolicyRepository.save(insurancePolicy);
	}

	@Override
	public InsurancePolicy getBYId(Integer insuId) {
		return insurancePolicyRepository.findById(insuId).orElseThrow(()-> new ResourceNotFoundException("Insurance Policy", "policy ", ""+insuId));
	}

	@Override
	public InsurancePolicy updateInsurancePolcy(InsurancePolicy insurancePolicy, Integer insuId) {
	    insurancePolicyRepository.findById(insuId).orElseThrow(()-> new  ResourceNotFoundException("Insurance Policy", "policy ", ""+insuId));
		InsurancePolicy newInsurance = mapper.map(insurancePolicy, InsurancePolicy.class);
		newInsurance.setId(insuId);
		return insurancePolicyRepository.save(newInsurance);
	}

	@Override
	public String deleteInsurancePolicy(Integer insuId) {
		InsurancePolicy insurancePolicy = insurancePolicyRepository.findById(insuId).orElseThrow(()-> new ResourceNotFoundException("Insurance Policy", "policy ", ""+insuId));
		insurancePolicyRepository.delete(insurancePolicy);
		return "Insurance policy deleted successfully...";
	}

	@Override
	public List<InsurancePolicy> getAllInsurancePolicy() {
		return insurancePolicyRepository.findAll();
	}

}
