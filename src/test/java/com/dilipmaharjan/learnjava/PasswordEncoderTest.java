package com.dilipmaharjan.learnjava;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordEncoderTest {
	@Test
	public void generateEncodedPassword() {
		PasswordEncoder password = new BCryptPasswordEncoder();
		System.out.println(password.encode("dilip@123"));
	}

	@Test
	public void generateEncodedPassword3() {
		PasswordEncoder password = new BCryptPasswordEncoder();
		System.out.println(password.encode("dilip@123"));
	}

	@Test
	public void generateEncodedPassword2() {
		PasswordEncoder password = new BCryptPasswordEncoder();
		System.out.println(password.encode("dilip@123"));
	}

	@Test
	public void generateEncodedPassword1() {
		PasswordEncoder password = new BCryptPasswordEncoder();
		System.out.println(password.encode("dilip@123"));
	}
}
