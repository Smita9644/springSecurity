package com.app.service;

import com.app.exception.InvalidDataException;
import com.app.exception.InvalidUserException;
import com.app.exception.NotFoundException;
import com.app.model.User;

public interface UserService {
	/**
	 * Create new user with auto generated id as a user_id
	 * 
	 * @param user
	 * @return User object
	 */
	public User addUser(User user) throws InvalidDataException;

	/**
	 * Update the old user record.
	 * 
	 * @param user
	 * @return user object if the user_id not found create new user.
	 * @throws NotFoundException 
	 */
	public User UpdateUser(User u) throws InvalidDataException, NotFoundException;

	/**
	 * In this method we are trying to delete user depending upon user_id
	 * 
	 * @param userId
	 * @return User object(if found) If user id not found then @throws
	 *         NotFoundException
	 * 
	 */
	public String deleteUser(int id) throws InvalidDataException, NotFoundException;

	/**
	 * In this method we are trying get all the details of specific user depending
	 * upon user_id
	 * 
	 * @param userId
	 * @return User object(if found)
	 * @throws NotFoundException
	 * 
	 */
	public User getUserById(Integer userId) throws InvalidDataException, NotFoundException;

	/**
	 * In this method we try to validate that user i.e we check the email and
	 * password of the user
	 * 
	 * @param String email
	 * @param String password
	 * @return User object(if it is correct) if email or pass is incorrect
	 *         throws @throws InvalidUserException
	 */
	public User validateUser(String email, String password)
			throws InvalidDataException, NotFoundException, InvalidUserException;
}
