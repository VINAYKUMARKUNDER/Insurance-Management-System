package com.vinay.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vinay.model.Claim;

public interface ClaimRepository extends JpaRepository<Claim, Integer>{

}
