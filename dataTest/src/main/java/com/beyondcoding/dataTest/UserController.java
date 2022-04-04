package com.beyondcoding.dataTest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {

	public UserRepository dao;
	
	@GetMapping(path="/all")
	public List<User> getAllUsers() {
		List<User> foundUsers = dao.findAll();
		System.out.println("Works"); //Error isn't with SQL, it's with Spring
		return foundUsers;
	}
	
//	@GetMapping("/user/")
//    public ResponseEntity<User> getUser(@PathVariable(value="user_email") String user_email) {
//        User foundUser = dao.findByUsername(user_email);
//
//        if(foundUser == null) {
//            return ResponseEntity.notFound().header("User","Nothing found with that user_email").build();
//        }
//        return ResponseEntity.ok(foundUser);
//}
	}
