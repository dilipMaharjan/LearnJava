package com.dilipmaharjan.learnjava.springsecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
				.inMemoryAuthentication()
				.withUser("dilip")
				.password("$2a$10$LwvXj.du2yUfYDeKK6L1SuXk.PfSmv6ceTitgedCxwbDGdbflTXXO")
				.roles("USER", "ADMIN");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.csrf().disable()
				.authorizeRequests()
				.antMatchers("/customers/**").permitAll()
				.antMatchers("/console/**").permitAll()
				.antMatchers("/admin/**").hasAnyRole("ADMIN")
				.anyRequest().hasAnyRole("USER").and()
				.formLogin()
				.loginPage("/login")
				.defaultSuccessUrl("/dashboard")
				.permitAll();
		http.headers().disable();

	}
}
