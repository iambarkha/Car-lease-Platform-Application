package com.car.lease.brokerservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle {
	
	private Long id;
	private String make;
	private String model;
	private String version;
	private String numberOfDoors;
	private String co2Emission;
	private double grossPrice;
	private double nettPrice;

}
