package com.anrisys.team_flow.users.application.service;

public record RegisterUserCommand(
		String email,
		String password,
		String firstName,
		String lastName
		) {}
