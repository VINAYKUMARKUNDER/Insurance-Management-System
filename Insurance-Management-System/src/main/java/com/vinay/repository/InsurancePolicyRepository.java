package com.vinay.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vinay.model.InsurancePolicy;

public interface InsurancePolicyRepository extends JpaRepository<InsurancePolicy, Integer>{

}
