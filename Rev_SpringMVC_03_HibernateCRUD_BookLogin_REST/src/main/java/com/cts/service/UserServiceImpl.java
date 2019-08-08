package com.cts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cts.dao.UserDAO;
import com.cts.model.App_User;

@Service("userService")
public class UserServiceImpl implements UserService {
	 @Autowired
	    UserDAO userdao;

	@Override
	@Transactional
	public App_User getUserbyUsername(String theUser) {
		App_User theuser=userdao.fetchUserNameId(theUser);
		System.out.println(" The fetched user is "+ theuser);
		return theuser;
	}
	
	@Override
	@Transactional
	public void createUser(App_User theUser) {
		userdao.addBook(theUser);
	}
	
	
	 

}
