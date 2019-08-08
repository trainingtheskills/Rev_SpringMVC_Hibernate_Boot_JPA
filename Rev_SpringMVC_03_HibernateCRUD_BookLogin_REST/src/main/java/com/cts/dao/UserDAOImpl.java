package com.cts.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cts.model.App_User;
@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	 SessionFactory sessionFact;
	
	
	@Override
	public App_User fetchUserNameId(String username) {
		Session currentSession = sessionFact.getCurrentSession();
		App_User theUser= currentSession.get(App_User.class, username);
		return theUser;
	}


	@Override
	public void addBook(App_User theUser) {
		Session currentSession = sessionFact.getCurrentSession();
		sessionFact.getCurrentSession().saveOrUpdate(theUser);
		
	}

	

}
