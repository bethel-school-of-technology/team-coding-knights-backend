package com.slugguts.finalproject.services;

import org.springframework.stereotype.Service;

import com.slugguts.finalproject.models.User;
import com.slugguts.finalproject.repositories.UserRepository;


@Service
public class UserServiceImpl implements UserService {
	
	private UserRepository userRepository;
	
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	};
	@Override
	public User saveUser (User user) {
		return userRepository.save(user);
	}
}