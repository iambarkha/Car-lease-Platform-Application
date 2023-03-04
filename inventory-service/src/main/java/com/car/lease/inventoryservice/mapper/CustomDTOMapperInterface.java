package com.car.lease.inventoryservice.mapper;

import org.mapstruct.Mapper;

import com.car.lease.inventoryservice.model.Vehicle;
import com.car.lease.inventoryservice.model.dto.VehicleDTO;
/**
 * This class represent a mapper to convert Customer model to DTO and vice versa.
 * 
 * @author barkha
 *
 */
@Mapper
public interface CustomDTOMapperInterface {
	/**
	 * This method is used to convert VehicleDTO request to Vehicle model object.
	 * 
	 * @param request VehicleDTO request object.
	 * @return Vehicle model object.
	 */
	Vehicle dtoToVehicle(VehicleDTO vehicleDto);
	/**
	 * This method is used to convert Vehicle model object to VehicleDTO.
	 * 
	 * @param  Vehicle model object.
	 * @return VehicleDTO response object.
	 */
	VehicleDTO createDtoFromVehicle(Vehicle vehicle);

}
