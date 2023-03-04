package com.car.lease.brokerservice.service;

import com.car.lease.brokerservice.model.LeaseRequest;
import com.car.lease.brokerservice.model.LeaseResponse;
/**
 * this interface is used to calculate lease rate monthly basis.
 * 
 * @author barkha
 */
public interface LeaseService {
	/**
	 * This method is used to calculate lease rate on basis of mileage, duration and
	 * interest rate.
	 * 
	 * @param leaseRequest
	 * @return LeaseResponse object which keeps basic lease response data for a
	 *         selected vehicle with monthly lease calculate rate
	 */
	LeaseResponse calculateLeaseRate(final LeaseRequest leaseRequest, String token);

}
