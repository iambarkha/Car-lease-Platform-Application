package com.car.lease.brokerservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.car.lease.brokerservice.exception.BrokerSystemException;
import com.car.lease.brokerservice.model.LeaseRequest;
import com.car.lease.brokerservice.model.LeaseResponse;
import com.car.lease.brokerservice.model.dto.VehicleDTO;
import com.car.lease.brokerservice.service.BrokerServiceClient;
import com.car.lease.brokerservice.service.LeaseService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class LeaseServiceimpl implements LeaseService{
	
	@Autowired
	private BrokerServiceClient brokerServiceClient;
	
	@Value("${inventory.service.url}")
	public String inventoryUrl;
	
	
	@Override
	public LeaseResponse calculateLeaseRate(LeaseRequest leaseRequest, String token) {
		log.trace("Received lease rate calculate request for vehicle :: {}", leaseRequest.getVehicleId());
		
		Long vehicleId = leaseRequest.getVehicleId();
		LeaseResponse leaseResponse = new LeaseResponse();
		String url = inventoryUrl + "findVehicleById/"+vehicleId;
		VehicleDTO vehicleResponse = brokerServiceClient.getRequestExchange(url, VehicleDTO.class, token).getBody();
		try {
			if(vehicleResponse != null) {
				// Calculate monthly lease rate.
				double rateByMilageAndDuration = (double) (((leaseRequest.getMilage() / 12) * leaseRequest.getDuration())
						/ vehicleResponse.getNettPrice());
				double rateByIntrestRate = ((leaseRequest.getInterestRate() / 100) * vehicleResponse.getNettPrice()) / 12;
				double monthlyLeaseRate = rateByIntrestRate + rateByMilageAndDuration;
				log.info("monthlyLeaseRate ========== " + monthlyLeaseRate);
				leaseResponse.setLeaseMontlyAmount(Double.valueOf(monthlyLeaseRate));
			}else {
				throw new BrokerSystemException("Choose valid vehicle");
			}
			
		} catch (Exception exe) {
			log.error("Exception while calculating lease rate", exe);
			throw new BrokerSystemException("Exception occured in lease calculation");
		}
		
		leaseResponse.setDuration(leaseRequest.getDuration());
		leaseResponse.setMilage(leaseRequest.getMilage());
		leaseResponse.setInterestRate(leaseRequest.getInterestRate());
		leaseResponse.setMake(vehicleResponse.getMake());
		leaseResponse.setModel(vehicleResponse.getModel());
		leaseResponse.setNettPrice(vehicleResponse.getNettPrice());
		leaseResponse.setVehicleId(vehicleId);
		log.trace("Lease rate calculated for Vehicle - "+ vehicleId );
		return leaseResponse;
	}

}
