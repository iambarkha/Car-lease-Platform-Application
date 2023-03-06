package com.car.lease.brokerservice.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LeaseResponse {
	
	private long milage;
	private int duration;
	private double interestRate;
	private double nettPrice;
	private long vehicleId;
	private String make;
	private String model;
	private double leaseMontlyAmount;

}
