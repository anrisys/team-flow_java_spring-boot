package com.anrisys.team_flow.users.domain.repository;

import java.util.Optional;

import com.anrisys.team_flow.users.domain.model.User;

public interface UserRepository {
	User save(User user);
	Optional<User> findByEmail(String email);
	boolean existsByEmail(String email);
}
