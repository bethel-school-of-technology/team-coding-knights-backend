package com.codeknights.ProEstimates1.controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codeknights.ProEstimates1.models.User;
import com.codeknights.ProEstimates1.repositories.UserRepository;
//import com.codeknights.ProEstimates1.services.MySQLUserDetailsService;


@RestController
@RequestMapping({} )
public class UsersController {
	
	UserRepository dao;
	
//	MySQLUserDetailsService UserDetailsService;
	
	@Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String user_first_name;
    

    @Value("${spring.datasource.password}")
    private String user_password;
    
	
	    @GetMapping("user/")
	    public List<User> getAllUsers(Model model) {
	        List<User> users = new ArrayList<User>();
	        Connection con;
	        try {
	            con = DriverManager.getConnection(url, user_first_name, user_password);
	            Statement stmt = con.createStatement();
	            ResultSet rs = stmt.executeQuery("SELECT * FROM user");
	            while (rs.next()) {
	                // create a new User object
	                User newUser = new User();
	                // get the values from each column of the current row and add them to the new Album
	                newUser.setUser_id(rs.getInt("user_id"));
	                newUser.setUser_first_name(rs.getString("user_first_name"));
	                newUser.setUser_last_name(rs.getString("user_last_name"));
	                newUser.setUser_password(rs.getString("user_password"));
	                newUser.setUser_email(rs.getString("user_email"));
	                newUser.setUser_phone_number(rs.getInt("user_phone_number"));
	                newUser.setUser_zip_code(rs.getInt("user_zip_code"));
	                // add the new user to the users list
	                users.add(newUser);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        model.addAttribute("users", users);
	    
	        return users;
	    }
	    
	    @PostMapping("/register/")
		public ResponseEntity<User> createUser(@RequestBody User user){
			
			User createdUser = dao.save(user);
			if (createdUser == null) {
				User newUser = new User();
				newUser.setUser_email(user.getUser_email());
				newUser.setUser_first_name(user.getUser_first_name());
				newUser.setUser_last_name(user.getUser_last_name());
				newUser.setUser_password(user.getUser_password());
				newUser.setUser_phone_number(user.getUser_phone_number());
				newUser.setUser_zip_code(user.getUser_zip_code());
//				userService.Save(newUser);
				return ResponseEntity.ok(createdUser);
			}else {
				user.addAttribute("exists", true);
				return ResponseEntity.ok().header("User",
						"was already created").build();
			}
			
		}
	    
}

//@RestController
//public class UsersController {
////	
//	@Autowired
//	 UserRepository dao;
//	
////	@Autowired
////	private MySQLUserDetailsService UserDetailsService;
//	
//	@GetMapping("/user/")
//    public ResponseEntity<User> getUser(@PathVariable(value="user_email") String user_email) {
//        User foundUser = dao.findByUsername(user_email);
//
//        if(foundUser == null) {
//            return ResponseEntity.notFound().header("User","Nothing found with that user_email").build();
//        }
//        return ResponseEntity.ok(foundUser);
//    }
//	@GetMapping("/quotes/user/{user_id}")
//    public String getQuotesPage() {
//        return "Quotes for User";
//    }
//
//  @PostMapping("/login")
//    public String getLoginPage() {
//        return "login";
//    }
//	
//	@PostMapping("/register/")
//	public ResponseEntity<User> createUser(@RequestBody User user){
//		
//		User createdUser = dao.save(user);
//		if (createdUser == null) {
//			User newUser = new User();
//			newUser.setUser_email(getLoginPage());
//			newUser.setUser_first_name(getLoginPage());
//			newUser.setUser_last_name(getLoginPage());
//			newUser.setUser_password(getLoginPage());
//			newUser.setUser_phone_number(0);
//			newUser.setUser_zip_code(0);
//			userService.Save(newUser);
//			return ResponseEntity.ok(createdUser);
//		}else {
//			user.addAttribute("exists", true);
//			return ResponseEntity.ok().header("User",
//					"was already created").build();
//		}
//		
//	}
////	@PostMapping("/register")
////	public String createUser(@RequestParam("username") String username, @RequestParam("password") String password, Model model) {
////		User foundUser = userRepository.findByUsername(username);
////		if (foundUser == null) {
////			User newUser = new User();
////			newUser.setUsername(username);
////			newUser.setPassword(password);
////			userService.Save(newUser);
////			return "login";
////		}
////		
////	}
//	
//	@PutMapping("/user/{user_id}")
//	public ResponseEntity<User> putUser (@PathVariable String user_email,@RequestBody User user) {
//		User foundUser = dao.findByUsername(user_email);
//		if (foundUser == null) {
//			return ResponseEntity.notFound().header("User",
//					"nothing found with that user_email").build();
//		}else {
//			if (user.getUser_first_name() != null) {
//				foundUser.setUser_first_name(user.getUser_first_name());
//			}
//			if (user.getUser_last_name() != null) {
//				foundUser.setUser_last_name(user.getUser_last_name());
//			}
//			if (user.getUser_email() != null) {
//				foundUser.setUser_email(user.getUser_email());
//			}
//			if (user.getUser_password() != null) {
//				foundUser.setUser_password(user.getUser_password());
//			}
//			if (user.getUser_zip_code() != 0) {
//				foundUser.setUser_zip_code(user.getUser_zip_code());
//			}
//			if (user.getUser_phone_number() != 0) {
//				foundUser.setUser_phone_number(user.getUser_phone_number());
//			}
//			
//			return ResponseEntity.ok(foundUser);
//			}
//	}
//	
//	@DeleteMapping("/user/delete")
//	public ResponseEntity<User> deleteUser(@PathVariable(value="user_email")String user_email){
//		User foundUser = dao.findByUsername(user_email);
//		
//		if(foundUser==null) {
//			return ResponseEntity.notFound().header("User", 
//					"nothing found with that user_email").build();
//		}else {
//			dao.delete(foundUser);
//		}
//		return ResponseEntity.ok().build();
//	}

