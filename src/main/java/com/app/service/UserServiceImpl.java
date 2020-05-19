package com.app.service;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.app.exception.InvalidDataException;
import com.app.exception.InvalidUserException;
import com.app.exception.NotFoundException;
import com.app.model.User;
import com.app.repository.UserRepository;
@Repository
public class UserServiceImpl implements UserService {

	/** auto wired UserRepository for accessing the methods of user repository */
	@Autowired
	UserRepository repository;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public UserServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Create new user with auto generated id as a user_id
	 * 
	 * @param user
	 * @return User object
	 */
	@Override
	public User addUser(User user) throws InvalidDataException {
            User u=new User();
		try {
		    u.setUserName(user.getUserName());  
		    u.setPassword(passwordEncoder.encode(user.getPassword()));
		    u.setUserEmail(user.getUserEmail());
		    u.setRole(user.getRole());
			repository.save(u);
		} catch (ConstraintViolationException ex) {

			throw new InvalidDataException("Email should be correct");
		}
	catch (DataIntegrityViolationException ex) {
			throw new InvalidDataException("Email is alerady exist");
		}
		return u;
	}

	/**
	 * Update the old user record.
	 * 
	 * @param user
	 * @return user object (if the user_id found). if user not found @throws
	 *         NotFoundException
	 */
	@Override
	public User UpdateUser(User user) throws InvalidDataException, NotFoundException {
		user.setUserEmail(this.getUserById(user.getUser_id()).getUserEmail());
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		repository.save(user);
		return user;

	}

	/**
	 * In this method we are trying to delete user depending upon user_id
	 * 
	 * @param userId
	 * @return User String i.e "user with given id is deleted"(if found)
	 * @throws NotFoundException
	 * 
	 */
	@Override
	public String deleteUser(int id) throws InvalidDataException, NotFoundException {
		// TODO Auto-generated method stub
		repository.findById(id).orElseThrow(() -> new NotFoundException("user with given yuser id does not exits"));
		repository.deleteById(id);
		return "User with id " + id + " is deleted";
	}

	/**
	 * In this method we are trying get all the details of specific user depending
	 * upon user_id
	 * 
	 * @param userId
	 * @return User object(if found)
	 * @throws NotFoundException
	 * 
	 */
	@Override
	public User getUserById(Integer id) throws InvalidDataException, NotFoundException {
		// TODO Auto-generated method stub
		User u = repository.findById(id).orElseThrow(() -> new NotFoundException("unable to find user with given id"));
		return u;
	}

	/**
	 * In this method we try to validate that user i.e we check the email and
	 * password of the user
	 * 
	 * @param String email
	 * @param String password
	 * @return User object(if it is correct) if email or pass is incorrect
	 *         throws @throws InvalidUserException
	 */
	@SuppressWarnings("unused")
	@Override
	public User validateUser(String userEmail, String password)
			throws InvalidDataException, NotFoundException, InvalidUserException {
		String userPassword=passwordEncoder.encode(password);
		User u = repository.ValidateUser(userEmail);
		boolean isPasswordMatch = passwordEncoder.matches(u.getPassword(), userPassword);
		if (u == null)
			throw new InvalidUserException("Unable to find user with this email");
		if(isPasswordMatch==true)
		{
			return u;
		}else
		{
			throw new InvalidUserException("Password incorrect");
		}		
	}


}
