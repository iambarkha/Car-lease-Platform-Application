package com.car.lease.inventoryservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="VEHICLE")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;
	@Column(name = "MAKE", length = 100, nullable = false)
	private String make;
	@Column(name = "MODEL", length = 100, nullable = false)
	private String model;
	@Column(name = "VERSION", length = 100)
	private String version;
	@Column(name = "NUMBER_OF_DOORS", length = 50)
	private String numberOfDoors;
	@Column(name = "CO2_EMISSION", length = 100)
	private String co2Emission;
	@Column(name = "GROSS_PRICE", precision = 8, scale = 2)
	private double grossPrice;
	@Column(name = "NETT_PRICE", precision = 8, scale = 2)
	private double nettPrice;

}
