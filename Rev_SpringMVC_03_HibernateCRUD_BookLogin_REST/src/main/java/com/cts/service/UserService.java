
package com.cts.service ;


import com.cts.model.App_User;




public interface UserService {
	App_User getUserbyUsername(String theUser);
	void createUser(App_User theUser);
	}
