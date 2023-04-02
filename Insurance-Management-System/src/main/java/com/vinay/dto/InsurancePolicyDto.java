package com.vinay.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class InsurancePolicyDto {
	
	
    private Integer id;
  
    private String policyNumber;

    private String policyType;

    private BigDecimal coverageAmount;
  
    private BigDecimal premium;

    private LocalDate startDate;

    private LocalDate endDate;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "client_id")
//    private ClientDto client;

    @OneToMany(mappedBy = "policy",cascade = CascadeType.ALL)
    private Set<ClaimDto> claims = new HashSet<>();

}
