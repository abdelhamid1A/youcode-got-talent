package com.models.YoucodeGotTalent;


public class Admin extends User {
	private String Password;
// Constructor
	public Admin(long id, String lastName, String firstName, String phone, String Password) {
//		super(id, lastName, firstName, phone);
		this.Password = Password;
	}
// Getters and setters
	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}



}
