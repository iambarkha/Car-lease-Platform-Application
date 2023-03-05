package com.car.lease.authservice.model.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {
	 
	private Long id;
	@NotNull(message = "Use valid user username")
	@NotEmpty
	private String userName;
	@NotNull(message = "Password should not be null")
	@NotEmpty
	private String password;
	
}
