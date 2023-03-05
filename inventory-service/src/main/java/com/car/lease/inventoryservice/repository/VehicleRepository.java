package com.car.lease.inventoryservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.car.lease.inventoryservice.model.Vehicle;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long>{

}
