package com.vinay.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import com.vinay.model.Client;

import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InsurancePolicyDto {

    private Integer id;

    @NotBlank(message = "Policy Number is required")
    private String policyNumber;

    @NotBlank(message = "Policy Type is required")
    private String policyType;

    @NotNull(message = "Coverage Amount is required")
    @Positive(message = "Coverage Amount must be a positive number")
    private BigDecimal coverageAmount;

    @NotNull(message = "Premium is required")
    @Positive(message = "Premium must be a positive number")
    private BigDecimal premium;

    @NotNull(message = "Start Date is required")
    private LocalDate startDate;

    @NotNull(message = "End Date is required")
    private LocalDate endDate;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    private Client client;

    @OneToMany(mappedBy = "policy", cascade = CascadeType.ALL)
    private Set<ClaimDto> claims = new HashSet<>();
}
