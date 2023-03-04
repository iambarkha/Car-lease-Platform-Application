package com.car.lease.authservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.car.lease.authservice.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	/**
	 * This method is used find and return User object through a valid userName.
	 * 
	 * @param userName through which User object will fetch from database
	 * @return persist User object if userName is valid
	 */
	User findByUserName(String userName);

}
