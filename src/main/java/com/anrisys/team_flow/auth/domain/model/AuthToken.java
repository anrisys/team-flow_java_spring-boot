package com.anrisys.team_flow.auth.domain.model;

import java.time.Instant;

public record AuthToken(String accessToken, String refreshToken, Instant expiresAt, String tokenType) {
	public static AuthToken of(String accessToken, String refreshToken, Instant expiresAt) {
		return new AuthToken(accessToken, refreshToken, expiresAt, "Bearer");
	}
}
