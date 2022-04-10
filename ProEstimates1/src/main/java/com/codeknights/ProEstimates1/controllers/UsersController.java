package com.codeknights.ProEstimates1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import com.codeknights.ProEstimates1.models.User;
import com.codeknights.ProEstimates1.repositories.QuotesRepository;
import com.codeknights.ProEstimates1.repositories.UserRepository;
import com.codeknights.ProEstimates1.services.MySQLUserDetailsService;
import com.codeknights.ProEstimates1.util.LoginApiModel;
import com.codeknights.ProEstimates1.util.LoginRegisterApiModel;
import com.codeknights.ProEstimates1.util.RegisterApiModel;
import com.codeknights.ProEstimates1.util.UpdateUserApiModel;
import com.codeknights.ProEstimates1.models.Quote;

@CrossOrigin
@RestController
@RequestMapping()
public class UsersController {
	public UsersController(MySQLUserDetailsService mySQLUserDetailsService) {
		super();
		this.UserDetailsService = mySQLUserDetailsService;
	}
	@Autowired
	private QuotesRepository quotesRepository;
	@Autowired
	private UserRepository dao;
	private MySQLUserDetailsService UserDetailsService;
	
	@Value("${spring.datasource.url}")
    private String url;
	@Value("${spring.datasource.username}")
	private String username;
	@Value("${spring.datasource.password}")
	private String password;
	
	@GetMapping("/contractors")
	public List<User> getContractors(){
		List<User> contractors = dao.findAllContractors();
		return contractors;
	}
	
	    @PostMapping("/register")
	    public LoginRegisterApiModel postRegister(@RequestBody RegisterApiModel user) {
	        User new_user = user.toUserModel();
	    	this.UserDetailsService.Save(new_user);
	         LoginRegisterApiModel apiModel = new LoginRegisterApiModel();
	         apiModel.setProfile(new_user);
	         apiModel.setAccess_token("temporary");
	         

	        return apiModel;
	    }
	    @PostMapping("/login")
	    public LoginRegisterApiModel postLogin(@RequestBody LoginApiModel inApiModel) {
	         User user = this.UserDetailsService.GetUserFromUserName (inApiModel.getEmail());
	         LoginRegisterApiModel apiModel = new LoginRegisterApiModel();
	         apiModel.setProfile(user);
	         apiModel.setAccess_token("temporary"); 
	        return apiModel;
	    }
	    @PutMapping("/user/{user_id}")
	    public User updateUser (@PathVariable("user_id") int user_id, @RequestBody UpdateUserApiModel userUpdate) {
	    	User user = this.UserDetailsService.GetUserFromUserId (user_id);
	    	user.setUser_phone_number(userUpdate.getPhone());
	    	user.setUser_zip_code(userUpdate.getZip());
	    	user.setUser_first_name(userUpdate.getFirst_name());
	    	user.setUser_last_name(userUpdate.getLast_name());
	    	this.UserDetailsService.Update(user);
	    	
	    	return user;
	    }
	    @GetMapping ("/quotes/user/{user_id}")
	    public List<Quote> getUserQuotes (@PathVariable("user_id") int user_id) {
	    	 List<Quote> quotes = this.quotesRepository.findQuotesByUserId (user_id);
	    	return quotes;
	    }
	    
}
