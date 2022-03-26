package com.codeknights.ProEstimates1.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.codeknights.ProEstimates1.repositories.UserRepository;
import com.codeknights.ProEstimates1.models.User;

@Service
public class MySQLUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String user_email) {
		User user = userRepository.findByUsername(user_email);
		if (user == null) {
			throw new UsernameNotFoundException(user_email);
		}
		return new org.springframework.security.core.userdetails.User(user.getUser_email(), user.getUser_password(), getAuthorities());
	}

	public UserDetails Save(User newUser) {
		newUser.setUser_password(passwordEncoder.encode(newUser.getUser_password()));
		User savedUser = userRepository.save(newUser);
		return new org.springframework.security.core.userdetails.User(savedUser.getUser_email(), savedUser.getUser_password(), getAuthorities());
	}

	private List<SimpleGrantedAuthority> getAuthorities() {
		List<SimpleGrantedAuthority> authList = new ArrayList<>();
		authList.add(new SimpleGrantedAuthority("ROLE_USER"));
		return authList;
	}
}