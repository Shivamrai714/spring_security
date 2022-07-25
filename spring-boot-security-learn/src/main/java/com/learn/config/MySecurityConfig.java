package com.learn.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.learn.Services.CustomUserDetailService;

@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)         //when used @PreAuthorise to do work of ant Matchers
public class MySecurityConfig extends WebSecurityConfigurerAdapter 
{

	@Autowired
	private CustomUserDetailService customUserDetailService;
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		     .csrf().disable()                  //needed to add / update the object in postman
			.authorizeRequests()
			.antMatchers("/signin").permitAll()
			.antMatchers("/public/**").hasRole("NORMAL")                               //.antMatchers("/home","/login","/register").permitAll()
		    .antMatchers("/users/**").hasRole("ADMIN")
			.anyRequest()
			.authenticated()
			.and()
                                  //			.httpBasic()
			.formLogin()
			.loginPage("/signin")
			.loginProcessingUrl("/dologin")
			.defaultSuccessUrl("/users/")
			
			;
		
		     
		     
		
	
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		//auth.inMemoryAuthentication().withUser("shivam").password(this.passwordEncoder().encode("shivam")).roles("ADMIN");
		//auth.inMemoryAuthentication().withUser("john").password(this.passwordEncoder().encode("john")).roles("NORMAL");
		//auth.inMemoryAuthentication().withUser("ruchi").password(this.passwordEncoder().encode("ruchi")).roles("NORMAL");
	
		auth.userDetailsService(customUserDetailService).passwordEncoder(passwordEncoder());
		
	}	
	
	
	
	
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder(10);
	}
	
	
	
}
