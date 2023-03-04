package com.car.lease.brokerservice.service;



import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.car.lease.brokerservice.exception.BrokerSystemException;
import com.car.lease.brokerservice.mapper.CustomDTOMapperInterface;
import com.car.lease.brokerservice.model.Customer;
import com.car.lease.brokerservice.model.dto.CustomerDTO;
import com.car.lease.brokerservice.repository.CustomerRepository;
import com.car.lease.brokerservice.service.impl.CustomerServiceImpl;

@DisplayName("CustomerService - Unit Test")
@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {
	
	@InjectMocks
	CustomerServiceImpl customerService;
	
	@Mock
	CustomerRepository mockCustomerRepo;
	
	private static Customer customer = new Customer();
	private static CustomerDTO customerDto = new CustomerDTO();
	
	@BeforeAll
    public static void initiateCustomerBeforeTest(){
       
        customer.setId(1l);
		customer.setName("Barkha");
		customer.setPlace("Bangalore");
		customer.setStreet("Panathore Road");
		customer.setPhoneNumber("9987567789");
		customer.setEmailAddress("test@test.com");
		
		
		customerDto.setId(1l);
		customerDto.setName("Barkha");
		customerDto.setPlace("Bangalore");
		customerDto.setStreet("Panathore Road");
		customerDto.setPhoneNumber("9987567789");
		customerDto.setEmailAddress("test@test.com");
		
		

    }
	@Test
    public void addCustomerShouldReturnCustomerDTO() {
        when(mockCustomerRepo.save(customer)).thenReturn(customer);
        assertEquals(customerService.addCustomer(customerDto), customerDto);
    }
	@Test
	public void updateCustomerShouldReturnUpdatedCustomerDTOIfIdIsValid() {
        when(mockCustomerRepo.save(customer)).thenReturn(customer);
        assertEquals(customerService.updateCustomer(customerDto,1l), customerDto);
    }
	@Test
	public void updateCustomerShouldReturnExceptionIfIdIsInValid() {
        when(mockCustomerRepo.findById(1l)).thenReturn(Optional.empty());
        BrokerSystemException thrown = assertThrows(
        		BrokerSystemException.class,
                () -> customerService.updateCustomer(customerDto,1l), "Customer does not exist with id "
        );
        assertTrue(thrown.getMessage().contains("Customer does not exist with id"));
    }
	@Test
	public void deleteCustomerByIdShouldDeleteCustomer() {
		verify(mockCustomerRepo).deleteById(1l);
    }
	@Test
	public void findAllCustomersShouldReturnListOfAllCustomerDTO() {
		List<Customer> customerList = new ArrayList<>();
		customerList.add(customer);
        when(mockCustomerRepo.findAll()).thenReturn(customerList);
        assertEquals(customerService.findAllCustomers(),customerList);
    }
	
	@Test
	public void findCustomerByIdShouldReturnValidCustomerDTO() {
		Optional<Customer> optionalCustomer = Optional.of(new Customer());
		optionalCustomer.get().setId(1l);
		optionalCustomer.get().setName("Barkha");
        when(mockCustomerRepo.findById(1l)).thenReturn(optionalCustomer);
        assertEquals(customerService.findCustomerById(1l), optionalCustomer);
    }
	
	
	
	

}
