package com.vinay.dto;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.vinay.model.Address;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientDto {

	private Integer id;

	@NotBlank(message = "FirstName is required!!")
	private String firstName;

	@NotEmpty(message = "lastname is required!!")
	private String lastName;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Past(message = "DOB is must be in the Past!!")
	private LocalDate dateOfBirth;

	@Email(message = "Email is not valid!!")
	@Column(unique = true)
	private String email;

	@NotEmpty(message = "phone number is required!!")
	@Size(min = 10, max = 10, message = "phone number is must be only 10 digits!!")
	private String phoneNumber;

	@Size(min = 8, max = 20, message = "Password must be between 8 and 20 characters")
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]+$", message = "Password must contain at least one uppercase letter, one lowercase letter, one number and one special character")
	private String password;

	@NotEmpty(message = "about is required!!")
	@Column(columnDefinition = "TEXT")
	private String about;

	@Embedded
	private Address address;

}
