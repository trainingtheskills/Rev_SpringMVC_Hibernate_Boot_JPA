

package com.cts.dao;

import java.util.List;

import com.cts.model.Book;
import com.cts.model.Login;

public interface LoginDAO {

	public  void addLogin(Login login);
	public  Login fetchLoginbyUsername(String username);
	public  List<Login> getallUsers();

}
