package com.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
/**This is the configuration class for spring security*/
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	UserDetailsService userDetailService;
	
	
	/*@Bean
	@Override
	protected UserDetailsService userDetailsService() {
	 List<UserDetails> users=new ArrayList();
	 users.add(User.withDefaultPasswordEncoder().username("smita").password("123").roles("USER").build());
	 return new InMemoryUserDetailsManager(users);
	}*/
	
	/**Here we create a bean of BCryptPasswordEncoder*/
	@Bean
	public PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}
	
	/**This method is for providing authentication*/
	@Bean
	public AuthenticationProvider userAuthProvider()
	{
		DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailService);
		provider.setPasswordEncoder(new BCryptPasswordEncoder());
		return provider;
	}
	
	/**In this method we are disable the authentication from the given URLs */
	@Override
	public void configure(WebSecurity web) throws Exception {
	    web.ignoring().antMatchers("/addUser");
	    web.ignoring().antMatchers("/login");
	}
}
