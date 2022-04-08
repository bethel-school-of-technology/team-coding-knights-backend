package com.codeknights.ProEstimates1.models;

import javax.persistence.*;

@Entity
@Table(name="roles")
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int user_id;
	private boolean isAdmin;
	private boolean isContractor;
    protected Roles(){}
    public Roles(int user_id, boolean isAdmin, boolean isContractor){
        this.user_id = user_id;
        this.isAdmin = isAdmin;
        this.isContractor = isContractor;
    }
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public boolean isAdmin() {
		return isAdmin;
	}
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	public boolean isContractor() {
		return isContractor;
	}
	public void setContractor(boolean isContractor) {
		this.isContractor = isContractor;
	}
}
