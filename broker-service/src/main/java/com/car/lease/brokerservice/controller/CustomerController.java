package com.car.lease.brokerservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.car.lease.brokerservice.model.dto.CustomerDTO;
import com.car.lease.brokerservice.service.CustomerService;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

/**
 * This class has all Apis to manage customer operation like
 * Add,update,delete,find customer operations
 * 
 * @author barkha
 *
 */
@RestController
@CrossOrigin
@RequestMapping("/broker")
@Tag(name = "Customer controller API to  manage customer")
@Slf4j
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	

	@GetMapping("/findAllCustomers")
	public ResponseEntity<List<CustomerDTO>> getAllCustomers() {
		log.trace("Inside findAllCustomers");
		List<CustomerDTO> customers = customerService.findAllCustomers();
		log.info("Inside findAllCustomers", customers);
		return new ResponseEntity<>(customers, HttpStatus.OK);
	}

	/**
	 * This method is used to add a new customer in CUSTOMER table.
	 * 
	 * @param request Customer dto Object
	 * @return Customer response object after successful customer creation
	 */
	@PostMapping(value = "/create")
	public ResponseEntity<CustomerDTO> addCustomer(@RequestBody CustomerDTO cust) {
		log.trace("Inside add customer with request ", cust);
		return new ResponseEntity<CustomerDTO>(customerService.addCustomer(cust), HttpStatus.CREATED);
	}

	/**
	 * This method is used to update customer
	 * 
	 * @param request customer dto object
	 * @param id
	 * @return updated customer dto
	 */
	@PutMapping("/updateCustomer/{id}")
	public ResponseEntity<CustomerDTO> updateCustomer(@RequestBody CustomerDTO cust, @PathVariable Long id) {
		log.trace("Inside update customer for customer id", id);
		CustomerDTO customer = customerService.updateCustomer(cust, id);
		log.trace("After update customer", customer);
		return new ResponseEntity<CustomerDTO>(customer, HttpStatus.CREATED);
	}

	/**
	 * This method is used to find customer by a customer id.
	 * 
	 * @param customer id
	 * @return matched customer dto
	 */
	@GetMapping("/findCustomerById/{id}")
	public ResponseEntity<CustomerDTO> findCustomerById(@PathVariable Long id) {
		CustomerDTO customer = customerService.findCustomerById(id);
		log.trace("Inside findCustomerById customer id", id);
		return new ResponseEntity<>(customer, HttpStatus.OK);
	}

	/**
	 * This method is used to delete customer with a customer id
	 * 
	 * @param customer id
	 */
	@DeleteMapping("/delete/{id}")
	public ResponseEntity deleteCustomerById(@PathVariable("id") Long id) {
		log.trace("Inside deleteCustomerById ",id);
		customerService.deleteCustomerById(id);
		return new ResponseEntity(HttpStatus.OK);
	}
	
}
