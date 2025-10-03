package com.anrisys.team_flow.api.auth.dto.request;

public record RegisterRequest(
		String email,
		String password, 
		String confirmPassword,
		String firstName,
		String lastName
) {}
