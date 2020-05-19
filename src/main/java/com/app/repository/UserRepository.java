package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	/**
	 * This method is for validating user i.e to check user with given email and
	 * password is present or not
	 * @param String email and password
	 * @return User object
	 */
	@Query(value = "select * from User u where u.user_email = :userEmail", nativeQuery = true)
	User ValidateUser(@Param("userEmail") String userEmail);
	
	User findByUserName(String userName);

}
