package com.codeknights.ProEstimates1.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


import com.codeknights.ProEstimates1.models.User;
import com.codeknights.ProEstimates1.repositories.UserRepository;


@Service
public class MySQLUserDetailsService implements UserDetailsService {
	
	@Autowired
	UserRepository userRepository;
	@Autowired
	PasswordEncoder passwordEncoder;


	
	public User GetUserFromUserName(String user_email) {
		User user = userRepository.GetByEmail(user_email);
		if (user == null) {
			throw new UsernameNotFoundException(user_email);
		}
		return user;
	}
	public User GetUserFromUserId(int user_id) {
		User user = userRepository.GetById(user_id);
		if (user == null) {
			throw new UsernameNotFoundException("");
		}
		return user;
	}

	public User Save(User newUser) {
		newUser.setUser_password(passwordEncoder.encode(newUser.getUser_password()));
		User savedUser = userRepository.save(newUser);
		return savedUser;
}
	public User Update(User newUser) {
		User updatedUser = userRepository.save(newUser);
		return updatedUser;
}
	private List<SimpleGrantedAuthority> getAuthorities() {
		List<SimpleGrantedAuthority> authList = new ArrayList<>();
		authList.add(new SimpleGrantedAuthority("ROLE_USER"));
		return authList;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
}