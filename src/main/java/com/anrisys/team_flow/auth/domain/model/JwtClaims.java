package com.anrisys.team_flow.auth.domain.model;

import java.time.Instant;
import java.util.Map;

public record JwtClaims(String userId, String role, Instant issuedAt, Instant expiration) {
	public Map<String, Object> toClaims() {
		return Map.of("userId", userId, "role", role, "iat", issuedAt.getEpochSecond(), "exp",
				expiration.getEpochSecond());
	}
}
