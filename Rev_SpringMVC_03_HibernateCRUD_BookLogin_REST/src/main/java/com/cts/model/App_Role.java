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
@Table(name = "App_Role")
public class App_Role{
	 @Id
	   @GeneratedValue(strategy=GenerationType.IDENTITY)
	   @Column(name = "role_id")
	 int role_id;
	 
	 @Column(name = "role_name")
      String role_name;

	public App_Role() {
		super();
		// TODO Auto-generated constructor stub
	}

	public App_Role(int role_id, String role_name) {
		super();
		this.role_id = role_id;
		this.role_name = role_name;
	}

	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}

	public String getRole_name() {
		return role_name;
	}

	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}

	@Override
	public String toString() {
		return "App_Role [role_id=" + role_id + ", role_name=" + role_name + "]";
	}
    
    //Default Constructor
	 
	}
