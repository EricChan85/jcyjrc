package org.yjrc.config;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {

	@Override
	public void onAuthenticationFailure(HttpServletRequest arg0, HttpServletResponse arg1, AuthenticationException arg2)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		String jsonPayload = "{\"message\" : \"%s\", \"timestamp\" : \"%s\" }";
        arg1.getOutputStream().println(String.format(jsonPayload, arg2.getMessage(), Calendar.getInstance().getTime()));
	}

}
