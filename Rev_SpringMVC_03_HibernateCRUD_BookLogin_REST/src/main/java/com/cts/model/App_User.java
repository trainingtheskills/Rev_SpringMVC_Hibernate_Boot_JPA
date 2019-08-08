package com.cts.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

//import org.hibernate.validator.constraints.Email;

@Entity
@Table(name = "App_user1")
public class App_User{
	 @Id
	   @GeneratedValue(strategy=GenerationType.IDENTITY)
	   @Column(name = "user_id")
	 int user_id;
	 
	 @Column(name = "user_name",unique=true)
	 
      String user_name;
	 
	 @Column(name = "password", unique = true)
     String password;
	 
	 @Column(name = "enabled")
     String enabled;

	public App_User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public App_User(int user_id, String user_name, String password, String enabled) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.password = password;
		this.enabled = enabled;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEnabled() {
		return enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

    
	}
