package com.springboot.firstwebapp;

import java.util.function.Function;

import static org.springframework.security.config.Customizer.withDefaults;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.jaas.memory.InMemoryConfiguration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {
//	LDAP or Database
//  In memory
	
//	InMemoryUserDetailsManager
//	InMemoryUserDetailsManager(UserDetails... users)
	
	@SuppressWarnings("deprecation")
	@Bean
	public InMemoryUserDetailsManager createUserDetailsManager() {
		
		
		
//		private String username="in28minutes";
//		private String password="dummy";
		
		UserDetails userDetails1 = createNewUser("in28minutes","dummy");
		UserDetails userDetails2 = createNewUser("user","password");
		return new InMemoryUserDetailsManager(userDetails1, userDetails2);
		
	}

	private UserDetails createNewUser(String username, String password) {
		
		Function<String, String> passwordEncoder
		=new Function<String, String>() {
			public String apply(String input) {
				return passwordEncoder().encode(input);
			}
		};
		
		UserDetails userDetails = User.builder()
				                  .passwordEncoder(passwordEncoder)
				                  .username(username)
				                  .password(password)
				                  .roles("USER","ADMIN")
				                  .build();
		return userDetails;
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
//	all urls are protected
//	A login form is shown for unauthorized requests
//	CSRF disabled
//	Frames
	
//	@Bean
//	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
//		http.authorizeHttpRequests(
//				new Customizer<AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry>() {
//					public void customize(
//							AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry auth) {
//						auth.anyRequest().authenticated();
//					}
//				}
//				);
//		http.formLogin(withDefaults());
//		http.csrf().disable();
//		http.headers().frameOptions().disable();
//		return http.build();
//	}
}
