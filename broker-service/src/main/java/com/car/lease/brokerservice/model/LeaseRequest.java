package com.car.lease.brokerservice.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LeaseRequest {
	private long milage;
	private int duration;
	private double interestRate;
	private long vehicleId;
}
