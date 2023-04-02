package com.vinay.dto;

import java.time.LocalDate;

import com.vinay.model.ClaimStatus;
import com.vinay.model.InsurancePolicy;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ClaimDto {
	
	private Integer id;

	
    private String claimNumber;

    private String description;

    private LocalDate claimDate;

    @Enumerated(EnumType.STRING)
    private ClaimStatus claimStatus;

//    @ManyToOne(fetch = FetchType.LAZY)
//    private InsurancePolicyDto policy;


}
