package com.codeknights.ProEstimates1.models;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private Integer user_id;
	@Column(name = "user_first_name")
	private String user_first_name;
	@Column(name = "user_last_name")
	private String user_last_name;
	@Column(name = "user_zip_code")
	private Integer user_zip_code;
	@Column(name = "user_phone_number")
	private Long  user_phone_number;
	@Column(name = "user_email")
	private String user_email;
	
	// @see: https://stackoverflow.com/questions/23101260/ignore-fields-from-java-object-dynamically-while-sending-as-json-from-spring-mvc
	@JsonIgnore
	@Column(name = "user_password")
	private String user_password;
//	had to change the class to public from protected so the controller could create a new User()
	public User(){}
    public User(String first_name, String last_name,int zip, String email, String password, Long phone) {
		
		user_first_name = first_name;
		user_last_name = last_name;
		user_zip_code = zip;
		user_email = email;
		user_password = password;
		user_phone_number = phone;
	}		
	
	//Getters & Setters
	
	
	
	public User orElse(User user) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public String getUser_first_name() {
		return user_first_name;
	}
	public void setUser_first_name(String user_first_name) {
		this.user_first_name = user_first_name;
	}
	public String getUser_last_name() {
		return user_last_name;
	}
	public void setUser_last_name(String user_last_name) {
		this.user_last_name = user_last_name;
	}
	public Integer getUser_zip_code() {
		return user_zip_code;
	}
	public void setUser_zip_code(Integer user_zip_code) {
		this.user_zip_code = user_zip_code;
	}
	public Long getUser_phone_number() {
		return user_phone_number;
	}
	public void setUser_phone_number(Long user_phone_number) {
		this.user_phone_number = user_phone_number;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public void addAttribute(String string, List<User> users) {
		// TODO Auto-generated method stub
		
	}
	public Integer getUser_id() {
		return user_id;
	}
	
	
	
	
}
