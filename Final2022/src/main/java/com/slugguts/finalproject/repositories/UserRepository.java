package com.slugguts.finalproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.slugguts.finalproject.models.User;

@Repository
public interface UserRepository extends JpaRepository <User, String>{

	User findByUsername(String user_email);
	
}