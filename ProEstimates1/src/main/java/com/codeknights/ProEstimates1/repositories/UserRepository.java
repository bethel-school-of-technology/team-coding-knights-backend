package com.codeknights.ProEstimates1.repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codeknights.ProEstimates1.models.User;

@Repository
public interface UserRepository extends JpaRepository <User, String>{

	User findByUsername(String user_email);}


//Need to put our thingys in here so that they do the thingy and create something useable by the service.