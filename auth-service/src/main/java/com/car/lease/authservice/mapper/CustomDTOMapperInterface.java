package com.car.lease.authservice.mapper;

import org.mapstruct.Mapper;

import com.car.lease.authservice.model.User;
import com.car.lease.authservice.model.dto.UserRequest;
import com.car.lease.authservice.model.dto.UserResponse;
/**
 * This class represent a mapper to convert user model to UserRequest and UserResponse and vice versa.
 * 
 * @author barkha
 *
 */
@Mapper
public interface CustomDTOMapperInterface {
	/**
	 * This method is used to convert UserRequest  request to User model object.
	 * 
	 * @param request UserRequest request object.
	 * @return User model object.
	 */
	User userRequestToUser(UserRequest userRequest);
	/**
	 * This method is used to convert user model object to UserResponse.
	 * 
	 * @param user User model object.
	 * @return UserResponse  response object.
	 */
	UserResponse userToUserResponse(User user);

}
