package com.codeknights.ProEstimates1.services;

import org.springframework.stereotype.Service;

import com.codeknights.ProEstimates1.models.User;
import com.codeknights.ProEstimates1.repositories.UserRepository;

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
