package com.cts.service;

import java.util.List;

import com.cts.model.Login;

public interface LoginService {
	public Login findByEmail(String theEmail);
	
	public void save(Login theLogin);
	
}
