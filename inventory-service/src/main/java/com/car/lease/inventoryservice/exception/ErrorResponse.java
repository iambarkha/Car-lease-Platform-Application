package com.car.lease.inventoryservice.exception;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponse {
	private String message;

	public ErrorResponse(String message) {
		super();
		this.message = message;
	}

}
