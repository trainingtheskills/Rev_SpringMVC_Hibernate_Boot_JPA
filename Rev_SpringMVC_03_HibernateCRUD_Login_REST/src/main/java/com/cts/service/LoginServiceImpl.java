package com.cts.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cts.dao.LoginDAOImpl;
import com.cts.model.Book;
import com.cts.model.Login;
@Service("loginservice")
public class LoginServiceImpl  implements LoginService{
	
	@Autowired
	LoginDAOImpl ld;
		
	public void save(Login theLogin) {
		ld.addLogin(theLogin);
		
	}

	@Override
	@Transactional
	public Login findByEmail(String theEmail) {
		Login al = ld.fetchLoginbyUsername(theEmail);
		return al;
	}

}
