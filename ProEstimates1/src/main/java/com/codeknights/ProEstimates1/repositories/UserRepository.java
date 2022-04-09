package com.codeknights.ProEstimates1.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.codeknights.ProEstimates1.models.User;

@Repository
public interface UserRepository extends JpaRepository <User, String>{
//	User findOne(Integer user_id);
	@Query (value="SELECT * FROM pro_estimates.user WHERE user_email = ?1", nativeQuery=true)
	User GetByEmail (String user_email );
	
	@Query (value="SELECT * FROM pro_estimates.user WHERE user_id = ?1", nativeQuery=true)
	User GetById (int user_id );
	
	@Query(value="SELECT user_id, user_email, user_first_name, user_last_name, user_phone_number, user_zip_code, user_password FROM pro_estimates.user INNER JOIN pro_estimates.roles USING(user_id) WHERE is_contractor = true",nativeQuery=true)
	List<User> findAllContractors();
}
