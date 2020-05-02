package org.yjrc.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author cyh
 *
   *  使用 Spring Security 中的加密BCryptPasswordEncoder
 * @date 2020年1月9日
 */
public class SSPWUtils {
	
	static BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(11);
	
	private static final String INITIAL_PASSWORD = "123456";
	
	public static boolean  tt(String rawPassword) {
		
		String password = /*"$2a$11$RbbWgbFw7yfB3jpAtIW8WedsVeoMoEAEL9TVY28uKtJUGAv8PvVmK";*/ encoder.encode(rawPassword);
		System.out.println(password);
		return encoder.matches(rawPassword, password);
	}
	
	
	public static String encode(String raw) {
		return encoder.encode(raw);
	}
	
	public static boolean matches(String raw, String encoded) {
		return encoder.matches(raw, encoded);		
	}
	
	public static String getEncodedInitialPassword() {
		return encoder.encode(INITIAL_PASSWORD);
	}
}
