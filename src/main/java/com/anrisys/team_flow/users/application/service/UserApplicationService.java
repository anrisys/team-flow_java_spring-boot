package com.anrisys.team_flow.users.application.service;

import com.anrisys.team_flow.users.domain.model.User;

public interface UserApplicationService {
	User registerUser(RegisterUserCommand command);
}
