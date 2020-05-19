package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * User entity has all the user information. Lambok library provides
 * 
 * @setter Setters for all the fields of entity
 * @getter getters for all the fields of entity
 * @EqualsAndHashcode and @toString for this Booking entity
 */
@Entity
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class User {
	/** User id is the primary key */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private int user_id;

	/** This field indicate name of the user */
	@Column(length = 50, name = "user_name")
	@NotNull(message = "Name should not be null")
	@NotEmpty(message = "Name should not be empty")
	private String userName;

	/** This field indicate contact email address of the user */
	@Column(length = 50, name = "user_email", unique = true)
	@NotNull(message = "Email should not be null")
	@NotEmpty(message = "Email should not be empty")
	@Email
	private String userEmail;

	/** This field indicate the login password for the use */
	@Column(length = 50, name = "user_password")
	@NotNull(message = "Password should not be null")
	@NotEmpty(message = "Password should not be empty")
	private String password;

	/** This field indicate role of the user */
	@Column(length = 50)
	@NotNull(message = "Role should not be null")
	@NotEmpty(message = "Role should not be empty")
	private String role;

	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(int userId) {
		this.user_id = userId;
	}

	public User(String userName, String userEmail, String password, String role) {
		super();
		this.userName = userName;
		this.userEmail = userEmail;
		this.password = password;
		this.role = role;
	}

	public User(int user_id, String userName, String userEmail, String password, String role) {
		super();
		this.user_id = user_id;
		this.userName = userName;
		this.userEmail = userEmail;
		this.password = password;
		this.role = role;
	}

}
