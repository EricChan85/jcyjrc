package org.yjrc.service;

import org.springframework.beans.factory.annotation.Autowired;
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
	public void changePassword(PasswordModel model) {
				
		User user = authenticationFacade.getLoginUser();
		User myUser = new User();
		myUser.setId(user.getId());
		myUser.setPassword(SSPWUtils.encode(model.getNewPassword()));
		userDao.changePassword(myUser);		
	}

}
