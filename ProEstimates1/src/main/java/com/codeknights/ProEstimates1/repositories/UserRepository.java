package com.codeknights.ProEstimates1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codeknights.ProEstimates1.models.User;

public interface UserRepository extends JpaRepository<User,String>{
	User findByUsername(String user_email);
}
