package com.car.lease.brokerservice.model.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class VehicleDTO {
	
	@NotNull(message = "Make should not be be null")
	private String make;
	@NotNull(message = "Model should not be null")
	private String model;
	private String version;
	private String numberOfDoors;
	private String co2Emission;
	private double grossPrice;
	@NotNull(message = "Nett Price should not be null")
	private double nettPrice;

}
