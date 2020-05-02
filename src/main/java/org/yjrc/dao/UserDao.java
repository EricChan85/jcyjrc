package org.yjrc.dao;

import org.yjrc.domain.User;

public interface UserDao {

	User getUserByUserName(String userName);
	
	/*
	 * "修改密码"
	 */
	void changePassword(User user);
	
	User getById(Integer id);
}
