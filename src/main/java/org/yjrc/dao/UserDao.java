package org.yjrc.dao;

import org.yjrc.domain.User;

public interface UserDao {

	User getUserByUserName(String userName);
	
	void changePassword(User user);
}
