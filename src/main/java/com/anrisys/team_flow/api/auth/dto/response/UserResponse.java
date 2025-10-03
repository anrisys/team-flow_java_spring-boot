package com.anrisys.team_flow.api.auth.dto.response;

public record UserResponse(
		String userID,
		String email,
		String firstName,
		String lastName,
		String role
		) {}
