package org.yjrc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.yjrc.config.AuthenticationFacade;
import org.yjrc.dao.UserDao;
import org.yjrc.domain.User;
import org.yjrc.models.PasswordModel;
import org.yjrc.utils.SSPWUtils;

public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private AuthenticationFacade authenticationFacade;
	
	@Override
	@Transactional
	public void changePassword(PasswordModel model) {
				
		User user = authenticationFacade.getLoginUser();
		User myUser = new User();
		myUser.setId(user.getId());
		myUser.setPassword(SSPWUtils.encode(model.getNewPassword()));
		userDao.changePassword(myUser);		
	}

	@Override
	public User getUserByUserName(String userName) {
		return this.userDao.getUserByUserName(userName);
	}

	@Override
	public void resetPassword(User user) {		 
		user.setPassword(SSPWUtils.getEncodedInitialPassword());
		userDao.changePassword(user);	
	}

	@Override
	public User getById(Integer id) {
		return this.userDao.getById(id);
	}

}
