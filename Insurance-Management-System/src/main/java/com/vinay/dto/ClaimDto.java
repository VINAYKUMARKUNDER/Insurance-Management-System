package com.vinay.dto;

import java.time.LocalDate;



import com.vinay.model.ClaimStatus;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClaimDto {

    private Integer id;

    @NotBlank(message = "Claim Number is required")
    private String claimNumber;

    @NotBlank(message = "Description is required")
    private String description;

    @NotNull(message = "Claim Date is required")
    private LocalDate claimDate;

    @NotNull(message = "Claim Status is required")
    private ClaimStatus claimStatus;

//    private InsurancePolicyDto policy;
}