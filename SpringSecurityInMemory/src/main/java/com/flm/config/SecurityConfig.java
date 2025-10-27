package com.flm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	
	@Bean
	public UserDetailsService userDetailsService() {
		String encode = passwordEncoder().encode("secret");
		System.out.println(encode);
		String pwd = passwordEncoder().encode("password");
		System.out.println(pwd);
		UserDetails user1 = User.builder()
				.username("nav")
				.password(encode)
				.build();
		UserDetails user2 = User.builder()
				.username("sri")
				.password(pwd)
				.build();
		return new InMemoryUserDetailsManager(user1, user2);
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain defaultSecurityFilterChian(HttpSecurity http) throws Exception {
			http
				.authorizeHttpRequests(
				authorize -> authorize.requestMatchers("/hi","/bye")
				.authenticated()
				.requestMatchers("/open")
				.permitAll()
				.requestMatchers("/noaccess")
				.denyAll())
				.formLogin(Customizer.withDefaults())
				.httpBasic(Customizer.withDefaults());
			
			return http.build();
	}
}
