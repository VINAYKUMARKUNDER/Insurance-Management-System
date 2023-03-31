package com.vinay.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseModel {
	
	private String Massege;
	private boolean status;
	private LocalDateTime DateAndTime;

}
