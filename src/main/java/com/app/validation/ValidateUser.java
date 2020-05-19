package com.app.validation;

import com.app.exception.InvalidDataException;
import com.app.model.User;

public class ValidateUser {
	public ValidateUser() {

	}

	/**
	 * In the given method we validate the user object
	 * 
	 * @param user object
	 * @throws InvalidDataException
	 */
	public boolean validateUser(User user) throws InvalidDataException {
		this.validateName(user.getUserName());
		this.validateRole(user.getRole());
		this.validatePassword(user.getPassword());
		this.validateEmail(user.getUserEmail());
		return true;
	}

	/**
	 * In the given method we validate the name of the user
	 * 
	 * @param String name
	 * @throws InvalidDataException
	 */
	public boolean validateName(String name) throws InvalidDataException {
		if (name == null) {
			throw new InvalidDataException("Unable to add object with null name in table");
		} else if (name == "")
			throw new InvalidDataException("name has zero length");
		else if (!name.matches("[a-zA-Z ]*[^@&#0-9]"))
			throw new InvalidDataException("Unable to add object with incorrect name");
		else
			return true;
	}

	/**
	 * In the given method we validate the role of the user
	 * 
	 * @param String role
	 * @throws InvalidDataException
	 */
	public boolean validateRole(String role) throws InvalidDataException {
		if (role == null) {
			throw new InvalidDataException("Unable to add object with null role in table");
		} else if (role == "")
			throw new InvalidDataException("role has zero length");
		else if (!role.matches("[a-zA-Z]*[^@&#0-9]"))
			throw new InvalidDataException("Unable to add object with incorrect role in table");
		else
			return true;
	}

	/**
	 * In the given method we validate the password enter by user
	 * 
	 * @param String password
	 * @throws InvalidDataException
	 */
	public boolean validatePassword(String password) throws InvalidDataException {
		if (password == null) {
			throw new InvalidDataException("Unable to add object with null name in table");
		} else if (password == "")
			throw new InvalidDataException("password has zero length");
		else
			return true;
	}

	/**
	 * In the given method we validate the email of the user
	 * 
	 * @param String email
	 * @throws InvalidDataException
	 */
	public boolean validateEmail(String email) throws InvalidDataException {
		if (email == null) {
			throw new InvalidDataException("Unable to add object with null email in table");
		} else if (email == "")
			throw new InvalidDataException("email has zero length");
		else
			return true;
	}

}
