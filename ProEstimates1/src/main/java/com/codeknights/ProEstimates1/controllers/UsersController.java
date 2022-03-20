package com.codeknights.ProEstimates1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codeknights.ProEstimates1.models.User;
import com.codeknights.ProEstimates1.repositories.UserRepository;

@RestController
@Controller
@RequestMapping({"/user"})
public class UsersController {
	
	@Autowired
	UserRepository dao;
	
	@GetMapping("/user")
	public List<User> getUsers() {
		List<User> foundUsers = dao.findAll();
		return foundUsers;
	}
	
	@PostMapping("/user")
	public ResponseEntity<User> postUser(@RequestBody User user){
		
		User createdUser = dao.save(user);
		return ResponseEntity.ok(createdUser);
	}
	
	@DeleteMapping("/user")
	public ResponseEntity<User> deleteUser(@PathVariable(value="user_id")Integer id){
		User foundUser = dao.findById(id).orElse(null);
		
		if(foundUser==null) {
			return ResponseEntity.notFound().header("User", 
					"nothing found with that id").build();
		}else {
			dao.delete(foundUser);
		}
		return ResponseEntity.ok().build();
	}
	
	@PutMapping("/user")
	public ResponseEntity<User> putUser (@PathVariable Integer id,@RequestBody User user) {
		User foundUser = dao.findById(id).orElse(null);
		if (foundUser == null) {
			return ResponseEntity.notFound().header("User",
					"nothing found with that id").build();
		}else {
			if (user.getUser_first_name() != null) {
				foundUser.setUser_first_name(user.getUser_first_name());
			}
			if (user.getUser_last_name() != null) {
				foundUser.setUser_last_name(user.getUser_last_name());
			}
			if (user.getUser_email() != null) {
				foundUser.setUser_email(user.getUser_email());
			}
			if (user.getUser_password() != null) {
				foundUser.setUser_password(user.getUser_password());
			}
			if (user.getUser_zip_code() != 0) {
				foundUser.setUser_zip_code(user.getUser_zip_code());
			}
			if (user.getUser_phone_number() != 0) {
				foundUser.setUser_phone_number(user.getUser_phone_number());
			}
			
			return ResponseEntity.ok(foundUser);
			}
	}
}