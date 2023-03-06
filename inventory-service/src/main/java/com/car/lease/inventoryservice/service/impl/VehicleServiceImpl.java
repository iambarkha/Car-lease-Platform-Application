package com.car.lease.inventoryservice.service.impl;

import com.car.lease.inventoryservice.exception.InventorySystemException;
import com.car.lease.inventoryservice.mapper.CustomDTOMapperInterface;
import com.car.lease.inventoryservice.model.Vehicle;
import com.car.lease.inventoryservice.model.dto.VehicleDTO;
import com.car.lease.inventoryservice.repository.VehicleRepository;
import com.car.lease.inventoryservice.service.VehicleService;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class VehicleServiceImpl implements VehicleService{

	@Autowired
	private VehicleRepository vehicleRepository;
	
	 CustomDTOMapperInterface mapper = Mappers.getMapper(CustomDTOMapperInterface.class);
	
	@Override
	public VehicleDTO addVehicle(VehicleDTO vh) {
		log.trace("Vehicle request to add new vehicle to inventory :: {}", vh);
		Vehicle vehicle = vehicleRepository.save(mapper.dtoToVehicle(vh));
		log.trace("Vehicle request to add new vehicle to inventory sucessfully");
		return mapper.createDtoFromVehicle(vehicle);
	}

	@Override
	public VehicleDTO updateVehicle(VehicleDTO vh, Long id) {
		log.trace("Vehicle request to update vehicle record :: {}", vh);
		Vehicle existingVehicle = vehicleRepository.findById(id)
				.orElseThrow(() -> new InventorySystemException("Vehicle does not exist with id " + id));
		Vehicle vehicle = vehicleRepository.save(mapper.dtoToVehicle(vh));
		log.trace("Vehicle request to update vehicle record sucessfull");
		return mapper.createDtoFromVehicle(vehicle);
	}

	@Override
	public void deleteVehicleById(Long id) {
		log.trace("Vehicle request to delete vehicle record by VehicleId :: {}", id);
		Vehicle vehicle = vehicleRepository.findById(id)
				.orElseThrow(() -> new InventorySystemException("Vehicle not found with id " + id));
		vehicleRepository.delete(vehicle);
		log.trace("Vehicle request to delete vehicle record by VehicleId sucessfull");
		
	}

	@Override
	public List<VehicleDTO> findAllVehicles() {
		log.trace("Vehicle request to fetch all vehicles record");
		List<Vehicle> vehicles = vehicleRepository.findAll();
		List<VehicleDTO> vehicleDtos = vehicles.stream().map(c-> mapper.createDtoFromVehicle(c)).collect(Collectors.toList());
		log.trace("Vehicle request to fetch all vehicles record sucessfull");
		return vehicleDtos;
	}

	@Override
	public VehicleDTO findVehicleById(Long id) {
		log.trace("Vehicle request to fetch vehicle record by VehicleId :: {}", id);
		Vehicle vehicle = vehicleRepository.findById(id)
				.orElseThrow(() -> new InventorySystemException("Vehicle not found with id " + id));
		log.trace("Vehicle request to fetch vehicle record by VehicleId sucessfull");
		return mapper.createDtoFromVehicle(vehicle);
	}

}
