package com.car.lease.brokerservice.mapper;

import org.mapstruct.Mapper;

import com.car.lease.brokerservice.model.Customer;
import com.car.lease.brokerservice.model.dto.CustomerDTO;
/**
 * This class represent a mapper to convert Customer model to DTO and vice versa.
 * 
 * @author barkha
 *
 */
@Mapper
public interface CustomDTOMapperInterface {
	/**
	 * This method is used to convert CustomerDTO  request to Customer model object.
	 * 
	 * @param request CustomerDTO request object.
	 * @return Customer model object.
	 */
	Customer dtoToCustomer(CustomerDTO customerDto);
	/**
	 * This method is used to convert customer model object to CustomerDTO.
	 * 
	 * @param customer Customer model object.
	 * @return CustomerDTO  response object.
	 */
	CustomerDTO createDtoFromCustomer(Customer customer);

}
