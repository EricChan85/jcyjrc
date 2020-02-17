package org.yjrc.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.yjrc.dao.UserDao;
import org.yjrc.domain.User;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public UserDetails loadUserByUsername(String userName) {
		User user = userDao.getUserByUserName(userName);
		if (user == null) {
			throw new UsernameNotFoundException(userName);
		}		
		org.springframework.security.core.userdetails.User userDetails = 
				new org.springframework.security.core.userdetails.User(
				userName, user.getPassword(), true, true, true, true, getAuthorities(user.getRole()));
		return userDetails;
	}
	
	private final Collection<? extends GrantedAuthority> getAuthorities(String roleName) {
		List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();       
		authList.add(new SimpleGrantedAuthority(roleName));      		  
		return authList;   
    }

}
