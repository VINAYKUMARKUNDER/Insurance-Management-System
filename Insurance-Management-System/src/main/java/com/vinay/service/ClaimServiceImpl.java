package com.vinay.service;

import java.time.LocalDate;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vinay.exception.ResourceNotFoundException;
import com.vinay.model.Claim;
import com.vinay.repository.ClaimRepository;


@Service
public class ClaimServiceImpl implements ClaimService {
	
	@Autowired
	private ClaimRepository claimRepository;

	@Autowired
	private ModelMapper modelMapper;
	
	
	@Override
	public Claim createNewClaim(Claim claim) {
		claim.setClaimDate(LocalDate.now());
		return claimRepository.save(claim);
	}

	@Override
	public Claim getClaimById(Integer claimId) {
		return claimRepository.findById(claimId).orElseThrow(()-> new ResourceNotFoundException("Claim ", "Claim id", ""+claimId));
	}

	@Override
	public Claim updateClaim(Claim claim, Integer claimId) {
		Claim claime = claimRepository.findById(claimId).orElseThrow(()-> new ResourceNotFoundException("Claim ", "Claim id", ""+claimId));
		Claim newClaim = modelMapper.map(claim, Claim.class);
		newClaim.setId(claimId);
		newClaim.setClaimDate(claime.getClaimDate());
		return claimRepository.save(newClaim);
	}

	@Override
	public String deleteClaim(Integer claimId) {
		Claim claim = claimRepository.findById(claimId).orElseThrow(()-> new ResourceNotFoundException("Claim ", "Claim id", ""+claimId));
		claimRepository.delete(claim);
		return "claim info delete successfully...";
	}

	@Override
	public List<Claim> getAllClaim() {
		return claimRepository.findAll();
	}

}
