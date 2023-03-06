package com.car.lease.brokerservice.model.dto;


import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerDTO {
	private Long id;
	@NotNull(message = "Name should not be null")
	private String name;
	@NotNull(message = "Street should not be null")
	@NotBlank(message = "Street should not be empty")
	private String street;
	@NotNull(message = "House Number should not be null")
	private String houseNumber;
	private String place;
	@Email(message = "Email should be a vaild email")
	private String emailAddress;
	private String phoneNumber;
	@NotNull(message = "Zipcode should not be null")
	private String zipCode;

}
