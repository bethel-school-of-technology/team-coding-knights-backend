package com.codeknights.ProEstimates1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codeknights.ProEstimates1.models.User;

@Repository
public interface UserRepository extends JpaRepository< User, String> {

//	User findByuser_email(String user_email);

	//public User findByUsername(String user_email);
}
