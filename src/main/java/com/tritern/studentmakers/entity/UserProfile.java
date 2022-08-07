package com.tritern.studentmakers.entity;

public class UserProfile {
	private String username;
	private String email;
	private long phonenumber;
	private String city;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(long phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "UserProfile [username=" + username + ", email=" + email + ", phonenumber=" + phonenumber + ", city="
				+ city + "]";
	}

}
