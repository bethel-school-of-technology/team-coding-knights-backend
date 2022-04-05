package com.codeknights.ProEstimates1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.codeknights.ProEstimates1.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

	@Query(value="SELECT user_id, user_email, user_first_name, user_last_name, user_phone_number, user_zip_code, user_password FROM user INNER JOIN roles USING(user_id) WHERE is_contractor = true",nativeQuery=true)
	List<User> findAllContractors();

//	User findByuser_email(String user_email);

	//public User findByUsername(String user_email);
}
