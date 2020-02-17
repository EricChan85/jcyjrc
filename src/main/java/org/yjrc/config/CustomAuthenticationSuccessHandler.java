package org.yjrc.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	
	public CustomAuthenticationSuccessHandler() {
		super();
	}
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		
		final HttpSession session = request.getSession(false);
		if (session != null) {
			session.setMaxInactiveInterval(1800);
			//Removes temporary authentication-related data which may have been stored in the session
		    //during the authentication process.
			session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
		}
		handle(request, response, authentication);
	}
	
	protected void handle(final HttpServletRequest request, final HttpServletResponse response, final Authentication authentication) throws IOException {
        final String targetUrl = "/welcome";

        if (response.isCommitted()) {            
            return;
        }

        redirectStrategy.sendRedirect(request, response, targetUrl);
    }

}
