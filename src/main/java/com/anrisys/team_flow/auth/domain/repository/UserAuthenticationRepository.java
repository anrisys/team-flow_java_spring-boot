package com.anrisys.team_flow.auth.domain.repository;

import java.util.Optional;

import com.anrisys.team_flow.auth.domain.model.UserCredentials;

public interface UserAuthenticationRepository {
	Optional<UserCredentials> findByEmail(String email);
}
