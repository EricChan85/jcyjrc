package org.yjrc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.session.HttpSessionEventPublisher;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.yjrc.dao.UserDao;
import org.yjrc.service.MyUserDetailsService;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDao userDao;	

    @Autowired
    private MyUserDetailsService userDetailsService;
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		/*auth.inMemoryAuthentication().withUser("xiaoming").password("123456").roles("USER");
		auth.inMemoryAuthentication().withUser("admin").password(encoder().encode("123456")).roles("ADMIN");*/
		
		/*auth.userDetailsService(userDetailsService)
			.passwordEncoder(encoder())
			.and()
			.authenticationProvider(authProvider())
			.jdbcAuthentication();*/
		
		auth.authenticationProvider(authProvider());
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring()
			.antMatchers("/static/**");		
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	    http
	      .csrf().disable()
	      .authorizeRequests()	     	        
	        .antMatchers("/welcome").permitAll() /*.anonymous()*/
	        .antMatchers("/login*", "/invalidSession*").permitAll()
	        .antMatchers("/settings/**", "/contacts/**", "/repair/**").hasRole("USER")	        
	        .antMatchers("/apartment/**").hasRole("STAFF")
	        .antMatchers("/admin/**").hasRole("ADMIN")	        
	        
	        .anyRequest().authenticated()
	        .and()
	      .formLogin()
	        .loginPage("/login")
	        .failureUrl("/login?error=true")
	        /*.loginProcessingUrl("/processlogin")*/
	        /*.defaultSuccessUrl("/welcome", true)*/
	        .successHandler(successHandler())
	        .and()
	      .logout()
	      	.deleteCookies("JSESSIONID")
	      	.logoutSuccessUrl("/welcome")
	        .and()
	      .sessionManagement()
	        .sessionFixation().migrateSession()
	        .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
	        /*.invalidSessionUrl("/invalidSession.html")*/
	        .maximumSessions(1)
	        .expiredUrl("/login");
	        
	    
	    CharacterEncodingFilter filter = new CharacterEncodingFilter();
	    filter.setEncoding("UTF-8");
	    filter.setForceEncoding(true);
	    http.addFilterBefore(filter, CsrfFilter.class);
	}	
	
	@Bean
    public DaoAuthenticationProvider authProvider() {
        final CustomAuthenticationProvider authProvider 
        	= new CustomAuthenticationProvider(userDao, userDetailsService);
        authProvider.setPasswordEncoder(encoder());
        return authProvider;
    }	

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder(11);
    }
    
    @Bean
    public HttpSessionEventPublisher httpSessionEventPublisher() {
        return new HttpSessionEventPublisher();
    }
    
    private AuthenticationSuccessHandler successHandler() {
        return new CustomAuthenticationSuccessHandler();
    }
}
