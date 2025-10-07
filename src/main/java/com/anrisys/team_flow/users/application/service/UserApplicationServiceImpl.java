package com.anrisys.team_flow.users.application.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.anrisys.team_flow.shared.security.PasswordEncoder;
import com.anrisys.team_flow.users.domain.model.User;
import com.anrisys.team_flow.users.domain.repository.UserRepository;

@Service
@Transactional
public class UserApplicationServiceImpl implements UserApplicationService {
	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;

	public UserApplicationServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		super();
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public User registerUser(RegisterUserCommand command) {
		if (userRepository.existsByEmail(command.email())) {
			throw new IllegalArgumentException("Email already exists: " + command.email());
		}
		
		User user = User.registerNew(command.email(), command.password(), command.firstName(), command.lastName(), passwordEncoder);
		
		return userRepository.save(user);
	}

}
