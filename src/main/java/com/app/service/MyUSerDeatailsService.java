package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.app.model.User;
import com.app.repository.UserRepository;

@Service
public class MyUSerDeatailsService implements UserDetailsService {
	/** Here we autowired userRepo for accessing methods of user repository */
	@Autowired
	UserRepository repo;

	/**
	 * In this method we can get the user by its name if user not found @throw
	 * UsernameNotFoundException Exception
	 * 
	 * @return UserDetails object
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = repo.findByUserName(username);
		if (user == null)
			throw new UsernameNotFoundException("User not found");
		return new UserDetailsImpl(user);
	}

}
