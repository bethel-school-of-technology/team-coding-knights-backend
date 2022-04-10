package com.codeknights.ProEstimates1.util;

import com.codeknights.ProEstimates1.models.User;

public class RegisterApiModel {
	private String email;
	private Long phone_number;
	private Integer zip_code;
	private String first_name;
	private String last_name;
	private String password;
	
	public User toUserModel() {
		return new User(this.first_name, this.last_name,this.zip_code, this.email, this.password,this.phone_number);
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public Long getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(Long phone_number) {
		this.phone_number = phone_number;
	}
	public Integer getZip_code() {
		return zip_code;
	}
	public void setZip_code(Integer zip_code) {
		this.zip_code = zip_code;
	}



	}