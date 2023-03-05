package com.car.lease.brokerservice.service;

import java.util.List;

import com.car.lease.brokerservice.model.dto.CustomerDTO;
/**
 * This interface keeps all customer service for CRUD operation.
 * 
 * @author barkha
 */
public interface CustomerService {
	
	/**
	 * This method is used to create a new customer.
	 * 
	 * @param request Customer request object which is require to create a new
	 *                customer.
	 * @return Customer dto response object 
	 */
	CustomerDTO addCustomer(CustomerDTO customer);
	/**
	 * This method is used to update customer record.
	 * 
	 * @param request    Customer request object which is require to modify customer
	 *                   record.
	 * @param customerId Long data type parameter which can identify customer.
	 * @return Customer dto response object 
	 */
	CustomerDTO updateCustomer(CustomerDTO request, Long customerId);
	/**
	 * This method is used to delete customer record from database through provided id
	 * 
	 * @param customerId Long data type parameter which can identify customer to
	 *                   delete the customer record from database.
	 */
	void deleteCustomerById(final Long id);
	/**
	 * This method is used to return all customer records from database.
	 * 
	 * @return List<CustomerDTO> all customers records from database.
	 */
	List<CustomerDTO> findAllCustomers();
	/**
	 * This method is used to find customer through customer id.
	 * 
	 * @param customerId Long data type parameter which can identify customer
	 * @return Customer dto object
	 */
	CustomerDTO findCustomerById(final Long id);
}
