package com.cts.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cts.model.Book;
import com.cts.model.Login;


@Repository("loginDAO")
public class LoginDAOImpl implements LoginDAO {
	@Autowired
	 SessionFactory sessionFact;
		
	@Override
	public void addLogin(Login login) {
		sessionFact.getCurrentSession().saveOrUpdate(login);
		System.out.println(" Data Saved");
		
	}

	
	
	@Override
	public Login fetchLoginbyUsername(String email) {
		Session currentSession = sessionFact.getCurrentSession();
		Login s= (Login) currentSession.get(Login.class, email);
		return s;
	 }



	@Override
	public List<Login> getallUsers() {
			ArrayList<Login> loginList= new ArrayList<>();

			//Session session=sessionFact.openSession();
			Query query = sessionFact.getCurrentSession().createQuery("from Login");
			query.setMaxResults(3);
			loginList = (ArrayList<Login>) query.list();	
			System.out.println("list in dao"+loginList);

			return loginList;
		}
	
}
