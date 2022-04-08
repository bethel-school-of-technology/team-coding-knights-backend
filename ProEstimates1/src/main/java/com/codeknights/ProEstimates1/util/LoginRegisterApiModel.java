package com.codeknights.ProEstimates1.util;

import com.codeknights.ProEstimates1.models.User;

public class LoginRegisterApiModel {
private User profile;
private String access_token;
public User getProfile() {
	return profile;
}
public void setProfile(User profile) {
	this.profile = profile;
}
public String getAccess_token() {
	return access_token;
}
public void setAccess_token(String access_token) {
	this.access_token = access_token;
}

}
