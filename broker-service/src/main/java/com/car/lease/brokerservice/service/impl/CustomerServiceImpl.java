package com.car.lease.brokerservice.service.impl;

import com.car.lease.brokerservice.exception.BrokerSystemException;
import com.car.lease.brokerservice.mapper.CustomDTOMapperInterface;
import com.car.lease.brokerservice.model.Customer;
import com.car.lease.brokerservice.model.dto.CustomerDTO;
import com.car.lease.brokerservice.repository.CustomerRepository;
import com.car.lease.brokerservice.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerRepository customerRepository;
	
	 CustomDTOMapperInterface mapper = Mappers.getMapper(CustomDTOMapperInterface.class);
	
	@Override
	public CustomerDTO addCustomer(CustomerDTO customerDto) {
		log.trace("New customer creation request going to execute::{}", customerDto);
		Customer customer = customerRepository.save(mapper.dtoToCustomer(customerDto));
		log.trace("New customer creation request executed");
		return mapper.createDtoFromCustomer(customer);
	}

	@Override
	public CustomerDTO updateCustomer(CustomerDTO cust, Long id) {
		log.trace("Customer update request  for :: {}", id);
		Customer existingCustomer = customerRepository.findById(id)
				.orElseThrow(() -> new BrokerSystemException("Customer does not exist with id " + id));
		Customer customer = customerRepository.save(mapper.dtoToCustomer(cust));
		log.trace("Customer updated sucessfully");
		return mapper.createDtoFromCustomer(customer);
	}

	@Override
	public void deleteCustomerById(Long id) {
		log.trace("Request to delete customer record :: {}", id);
		Customer customer = customerRepository.findById(id)
				.orElseThrow(() -> new BrokerSystemException("Customer not found with id " + id));
		customerRepository.delete(customer);
		log.trace("Request to delete customer request sucessfull");
		
	}

	@Override
	public List<CustomerDTO> findAllCustomers() {
		log.trace("Request received to fetch all customer data");
		List<Customer> customers = customerRepository.findAll();
		List<CustomerDTO> customerDtos = customers.stream().map(c-> mapper.createDtoFromCustomer(c)).collect(Collectors.toList());
		log.trace("Request executed sucessfully to fetch all customer data");
		return customerDtos;
	}

	@Override
	public CustomerDTO findCustomerById(Long id) {
		Customer customer = customerRepository.findById(id)
				.orElseThrow(() -> new BrokerSystemException("Customer not found with id " + id));
		return mapper.createDtoFromCustomer(customer);
	}

}
