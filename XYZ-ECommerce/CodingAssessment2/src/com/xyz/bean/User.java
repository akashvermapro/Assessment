package com.xyz.bean;
/* Java Code to store user object */
public class User {
	private String loginId;
	private String password;
	private String email;
	public User(String loginId, String password, String email) {
		this.loginId = loginId;
		this.password = password;
		this.email = email;
	}
	//Setting getters and setters
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
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
	//To String method
	@Override
	public String toString() {
		return "User [loginId=" + loginId + ", password=" + password + ", email=" + email + "]";
	}

}
