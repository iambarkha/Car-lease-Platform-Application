package com.car.lease.brokerservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.car.lease.brokerservice.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
