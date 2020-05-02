package org.yjrc.service;

import org.yjrc.domain.User;
import org.yjrc.models.PasswordModel;

public interface UserService {
	
	void changePassword(PasswordModel model);
	
	/*
	 * "通过用户名获取用户"
	 */
	User getUserByUserName(String userName);
	
	/*
	 * "通过id获取用户"
	 */
	User getById(Integer id);
	
	/*
	 * "重置密码"
	 */
	void resetPassword(User user);
}
