package com.car.lease.brokerservice.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.car.lease.brokerservice.model.LeaseRequest;
import com.car.lease.brokerservice.model.LeaseResponse;
import com.car.lease.brokerservice.model.dto.VehicleDTO;
import com.car.lease.brokerservice.service.impl.LeaseServiceimpl;

@DisplayName("LeaseService - Unit Test")
@ExtendWith(MockitoExtension.class)
public class LeaseServiceTest {
	
	@InjectMocks
	LeaseServiceimpl leaseService;
	public static final String URL = "http://localhost:7001/inventory/findVehicleById/1";
	@Mock
	BrokerServiceClient mockBrokerClient;
	
	@Mock
	VehicleDTO mockVehicleDTO;
	
	private static LeaseRequest leaseRequest = new LeaseRequest();
	
	@BeforeAll
	public void setLeaseRequest() {
		leaseRequest.setDuration(5000);
		leaseRequest.setInterestRate(5);
		leaseRequest.setMilage(50);
		leaseRequest.setVehicleId(1);
	}
	
	
	@Test
	public void calculateLeaseRateTest() {
	String token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHJpbmciLCJpYXQiOjE2Nzc3NDYzMTgsImV4cCI6MTY3Nzc0NzIxOH0.O2-qIAQC1O8K4XLrdzMFH9jrd1AXjQm3D-cVF7WiCe7J-sEz0RuxzwNnwnbx7dL_A48duVAwYn2vgiAageEryw";
	mockVehicleDTO.setMake("KIA");
	mockVehicleDTO.setNettPrice(50000);
	mockVehicleDTO.setModel("Sonet");
	when(mockBrokerClient.getRequestExchange(URL, VehicleDTO.class,token).getBody()).thenReturn(mockVehicleDTO);
	LeaseResponse leaseResponse = leaseService.calculateLeaseRate(leaseRequest, token);
	assertEquals(leaseResponse.getVehicleId(), leaseRequest.getVehicleId());
	}
	
}
