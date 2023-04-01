package com.vinay.exception;


public class ResourceNotFoundException extends RuntimeException{
		
	private String fieldName;
	private String fieldTitle;
	private String fieldInfo;
	
	
	public ResourceNotFoundException(String fieldName, String fieldTitle, String fieldInfo) {
		super(String.format("%s is not found with %s : %s",fieldName,fieldTitle,fieldInfo));
		this.fieldName = fieldName;
		this.fieldTitle = fieldTitle;
		this.fieldInfo = fieldInfo;
	}
	
	
	public ResourceNotFoundException(String msg) {
		super(String.format("%s",msg));
		this.fieldName = msg;
		
	}
	
	
	
	
}
