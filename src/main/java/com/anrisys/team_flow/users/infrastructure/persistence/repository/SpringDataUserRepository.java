package com.anrisys.team_flow.users.infrastructure.persistence.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anrisys.team_flow.users.infrastructure.persistence.entity.UserEntity;

public interface SpringDataUserRepository extends JpaRepository<UserEntity, Long>{
	Optional<UserEntity> findByEmail(String email);
	Optional<UserEntity> findByPublicID(UUID publicID);
	boolean existsByEmail(String email);
}
