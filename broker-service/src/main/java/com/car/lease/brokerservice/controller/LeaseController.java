package com.car.lease.brokerservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.car.lease.brokerservice.model.LeaseRequest;
import com.car.lease.brokerservice.model.LeaseResponse;
import com.car.lease.brokerservice.service.LeaseService;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

/**
 * This class represents as a lease calculator to calculate lease monthly rate
 * 
 * @author barkha
 *
 */
@RestController
@CrossOrigin
@RequestMapping("/lease")
@Tag(name = "Lease controller API to  calculate lease")
@Slf4j
public class LeaseController {
	
	@Autowired
	private LeaseService leaseService;
	/**
	 * This method is used to calculate lease rate.
	 * 
	 * @param leaseRequest LeaseRequest object with all parameters (mileage,
	 *                     duration and interest rate to calculate monthly lease
	 *                     rate)
	 * @return LeaseResponse object after calculating lease rate with provided
	 *         parameters to calculate lease rate.
	 */
	@PutMapping("/calculate/{Authorization}")
	public ResponseEntity<LeaseResponse> calculateLeaseAmount(@RequestBody LeaseRequest leaseRequest, @PathVariable("Authorization") String token) {
		log.trace("Calculate lease rate");
		LeaseResponse leaseResponse = leaseService.calculateLeaseRate(leaseRequest, token);
		return new ResponseEntity<LeaseResponse>(leaseResponse, HttpStatus.OK);
	}
	

}
