package com.codeknights.ProEstimates1.models;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Integer user_id;
	@Column(name = "user_first_name")
	private String user_first_name;
	@Column(name = "user_last_name")
	private String user_last_name;
	@Column(name = "user_zip_code")
	private Integer user_zip_code;
	@Column(name = "user_phone_number")
	private Integer user_phone_number;
	@Column(name = "user_email")
	private String user_email;
	@Column(name = "user_password")
	private String user_password;
	
			
	
	//Getters & Setters
	
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
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
	public Integer getUser_phone_number() {
		return user_phone_number;
	}
	public void setUser_phone_number(Integer user_phone_number) {
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
	public void addAttribute(String string, boolean b) {
		// TODO Auto-generated method stub
		
	}
	
	
}
