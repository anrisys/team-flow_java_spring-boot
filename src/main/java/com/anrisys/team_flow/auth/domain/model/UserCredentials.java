package com.anrisys.team_flow.auth.domain.model;

import com.anrisys.team_flow.shared.security.PasswordEncoder;

public record UserCredentials(String userId, String email, String passwordHash, String role) {
	public boolean verifyPassword(String rawPassword, PasswordEncoder encoder) {
		return encoder.matches(rawPassword, this.passwordHash);
	}
}
