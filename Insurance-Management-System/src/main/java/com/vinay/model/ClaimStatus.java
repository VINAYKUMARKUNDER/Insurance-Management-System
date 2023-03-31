package com.vinay.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ClaimStatus {
    SUBMITTED("Submitted"),
    IN_PROGRESS("In Progress"),
    APPROVED("Approved"),
    DENIED("Denied");

    private String displayName;

  
}
