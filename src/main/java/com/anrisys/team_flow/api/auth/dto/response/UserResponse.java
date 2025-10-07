package com.anrisys.team_flow.api.auth.dto.response;

import com.anrisys.team_flow.users.domain.model.User;

public record UserResponse(
		String userId,
		String email,
		String firstName,
		String lastName,
		String role
		) {
	public static UserResponse from(User user) {
		return new UserResponse(
				user.getId().toString(),
				user.getEmail(),
				user.getFirstName(),
				user.getLastName(),
				user.getRole()
				);
	}
}
