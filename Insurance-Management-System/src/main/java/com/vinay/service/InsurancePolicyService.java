package com.vinay.service;

import java.util.List;

import com.vinay.model.InsurancePolicy;

public interface InsurancePolicyService {
	
	
	/**
	 * 
	 * @param insurancePolicy: take all about InsurancePolicy detail like name, type, amount, duration
	 * after save all info in database
	 * @return: return a saved info in database.
	 */
	InsurancePolicy createNewInsurancePolicy(Integer clientId, InsurancePolicy insurancePolicy);
	
	/**
	 * 
	 * @param insuId: take insurance id by user and check this id able in database or not
	 * if in database this id not exit then throw a particular exception 
	 * if exit then take detail in a single variable
	 * @return: after all opration return this variable
	 */
	InsurancePolicy getById(Integer insuId);
	
	
	/**
	 * 
	 * @param insurancePolicy: take all about InsurancePolicy detail like name, type, amount, duration
	 * @param insuId :take insurance id by user and check this id able in database or not
	 * if in database this id not exit then throw a particular exception 
	 * if exit then take detail in a single variable
	 * 
	 * after this swap both insurance about all data and save in database;
	 * 
	 * @return: return a updated insurance policy detail
	 */
	InsurancePolicy updateInsurancePolcy(InsurancePolicy insurancePolicy, Integer insuId);
	
	/**
	 * 
	 * @param insuId: take insurance id by user and check this id able in database or not
	 * if in database this id not exit then throw a particular exception 
	 * if exit then take detail in a single variable
	 * 
	 * @return: return type a string msg like this insurance policy deleted in database successfully.
	 */
	String deleteInsurancePolicy(Integer insuId);
	
	/**
	 * 
	 * @return: this is return all insurance policy in a list
	 */
	List<InsurancePolicy> getAllInsurancePolicy();
	
	
	InsurancePolicy assignPolicyWithUser(Integer clientId, Integer policyId);
	
	

}
