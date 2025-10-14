package com.anrisys.team_flow.users.infrastructure.auth;

import org.springframework.stereotype.Component;

import com.anrisys.team_flow.auth.domain.model.UserCredentials;
import com.anrisys.team_flow.users.domain.model.User;

@Component
public class UserCredentialsMapper {
	public UserCredentials toUserCredentials(User user) {
		return new UserCredentials(user.getId().toString(), user.getEmail(), user.getHashedPassword(), user.getRole());
	}
}
