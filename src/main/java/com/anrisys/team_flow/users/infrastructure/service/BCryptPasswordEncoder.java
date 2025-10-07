package com.anrisys.team_flow.users.infrastructure.service;

import org.springframework.stereotype.Component;
import com.anrisys.team_flow.shared.security.PasswordEncoder;

@Component
public class BCryptPasswordEncoder implements PasswordEncoder {
	private final org.springframework.security.crypto.password.PasswordEncoder encoder;
	
	public BCryptPasswordEncoder() {
		this.encoder = new org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder();
	}

	@Override
	public String encode(String rawPassword) {
		return encoder.encode(rawPassword);
	}

	@Override
	public boolean matches(String rawPassword, String encodedPassword) {
		return encoder.matches(rawPassword, encodedPassword);
	}
}
