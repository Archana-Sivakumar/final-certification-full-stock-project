package com.cognizant.signup.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="confirmation")
public class Confirmation {
	@Id
	@Column(name = "co_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "co_token")
	private String token;
	@Column(name = "co_user_name")
	private String userName;
	public Confirmation() {
		super();
	}
	public Confirmation(int id, String token, String userName) {
		super();
		this.id = id;
		this.token = token;
		this.userName = userName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Override
	public String toString() {
		return "Confirmation [id=" + id + ", token=" + token + ", userName=" + userName + "]";
	}
	
	
}
