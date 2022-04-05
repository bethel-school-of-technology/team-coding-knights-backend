package com.codeknights.ProEstimates1.controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import com.codeknights.ProEstimates1.models.User;
import com.codeknights.ProEstimates1.repositories.UserRepository;
import com.codeknights.ProEstimates1.services.UserService;

@RestController
public class UsersController {
	
	
	public UsersController(UserService userService) {
		super();
		this.userService = userService;
		
	}


	public UserRepository dao;
	
	private UserService userService;
	
//	private MySQLUserDetailsService userService;
	
	@Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String username;
    

    @Value("${spring.datasource.password}")
    private String user_password;
    
    @GetMapping("/test1")
    public List<User> getAllUsers2(User user) {
        List<User> users = new ArrayList<User>();
        Connection con;
        try {
            con = DriverManager.getConnection(url, username, user_password);
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
        user.addAttribute("users", users);
        
    
        return users;
    }
	
	@PostMapping("/register/")
	public ResponseEntity<User> saveUser(@RequestBody User user){
		return new ResponseEntity<User>(userService.saveUser(user), HttpStatus.CREATED);
		}
	
	
	@DeleteMapping("/user/delete")
	public ResponseEntity<User> deleteUser(@PathVariable(value="user_email")String user_email){
		User foundUser = dao.findByUsername(user_email);
		
		if(foundUser==null) {
			return ResponseEntity.notFound().header("User", 
					"nothing found with that user_email").build();
		}else {
			dao.delete(foundUser);
		}
		return ResponseEntity.ok().build();
	}
}