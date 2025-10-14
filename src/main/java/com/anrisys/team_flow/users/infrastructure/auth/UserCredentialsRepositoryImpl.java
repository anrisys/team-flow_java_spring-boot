package com.anrisys.team_flow.users.infrastructure.auth;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.anrisys.team_flow.auth.domain.model.UserCredentials;
import com.anrisys.team_flow.auth.domain.repository.UserAuthenticationRepository;
import com.anrisys.team_flow.users.domain.repository.UserRepository;

@Component
public class UserCredentialsRepositoryImpl implements UserAuthenticationRepository {
	private final UserRepository userRepository;
	private final UserCredentialsMapper mapper;

	public UserCredentialsRepositoryImpl(UserRepository userRepository, UserCredentialsMapper mapper) {
		super();
		this.userRepository = userRepository;
		this.mapper = mapper;
	}

	@Override
	public Optional<UserCredentials> findByEmail(String email) {
		return userRepository.findByEmail(email).map(mapper::toUserCredentials);
	}

}
