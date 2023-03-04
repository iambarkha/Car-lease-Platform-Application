package com.car.lease.brokerservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
