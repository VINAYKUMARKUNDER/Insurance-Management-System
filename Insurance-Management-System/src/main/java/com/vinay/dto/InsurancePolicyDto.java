package com.vinay.dto;

import java.math.BigDecimal;
import java.time.LocalDate;


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
//    private Client client;
//
//    @OneToMany(mappedBy = "policy",cascade = CascadeType.ALL)
//    private Set<Claim> claims = new HashSet();

}
