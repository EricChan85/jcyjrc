package org.yjrc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.yjrc.dao.UserDao;
import org.yjrc.domain.User;

public class CustomAuthenticationProvider extends DaoAuthenticationProvider {
	
	private final UserDao userDao;
    
	@SuppressWarnings("unused")
	private UserDetailsService userDetailsService;
    
    public CustomAuthenticationProvider(UserDao userDao, UserDetailsService userDetailsService){
    	super();
    	this.setUserDetailsService(userDetailsService);
    	this.userDao = userDao;
    }
    
    @Override
    public Authentication authenticate(Authentication auth) throws AuthenticationException {
        final User user = userDao.getUserByUserName(auth.getName());
        if ((user == null)) {
            throw new BadCredentialsException("用户名或密码错误");
        }
        final Authentication result = super.authenticate(auth);
        return new UsernamePasswordAuthenticationToken(user, result.getCredentials(), result.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
