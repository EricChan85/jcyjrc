package org.yjrc.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author cyh
 *
   *  使用 Spring Security 中的加密BCryptPasswordEncoder
 * @date 2020年1月9日
 */
public class SSPWUtils {
	
	public static boolean  tt(String rawPassword) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(11);
		String password = /*"$2a$11$RbbWgbFw7yfB3jpAtIW8WedsVeoMoEAEL9TVY28uKtJUGAv8PvVmK";*/ encoder.encode(rawPassword);
		System.out.println(password);
		return encoder.matches(rawPassword, password);
	}
}
