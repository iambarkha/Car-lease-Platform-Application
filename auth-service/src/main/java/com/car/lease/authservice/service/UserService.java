package com.car.lease.authservice.service;

import com.car.lease.authservice.model.AuthenticationStatus;
import com.car.lease.authservice.model.LoginRequest;
import com.car.lease.authservice.model.User;
import com.car.lease.authservice.model.dto.UserRequest;
import com.car.lease.authservice.model.dto.UserResponse;
/**
 * This interface is operates all functions of a user
 * 
 * below are major service design in UserService interface Create user, update
 * user, delete user, fetch user
 * 
 * @author barkha
 *
 */
public interface UserService {
	/**
	 * This method is used to find user object through userName parameter.
	 * 
	 * @param username String parameter - which is unique in user table, through
	 *                 which user object can fetch
	 * @return User entity object- if userName is valid
	 */
	User findByUserName(String userName);
	/**
	 * This method is used to create a new user for user registration.
	 * 
	 * @param user UserRequest object having all basic fields that require to
	 *             register a user.
	 * @return UserResponse object after successful of user registration
	 */
	UserResponse createUser(final UserRequest user);
	AuthenticationStatus getAuthenticationStatus(LoginRequest request);


}
