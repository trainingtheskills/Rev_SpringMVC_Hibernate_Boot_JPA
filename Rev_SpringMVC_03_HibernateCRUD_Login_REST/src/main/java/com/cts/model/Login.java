package com.cts.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "login")
public class Login {
	
	 @Id
     @Column(name = "email",unique=true)
	String email;
	 
	 @Column(name = "password")
	String password;
	 
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
