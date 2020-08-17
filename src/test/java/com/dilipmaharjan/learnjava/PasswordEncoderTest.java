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
}
