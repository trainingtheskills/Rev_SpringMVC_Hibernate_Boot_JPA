

package com.cts.dao;

import com.cts.model.App_User;
import com.cts.model.Book;

public interface UserDAO {
	
	public  App_User  fetchUserNameId(String username);
	public void addBook(App_User theUser);
	
}
