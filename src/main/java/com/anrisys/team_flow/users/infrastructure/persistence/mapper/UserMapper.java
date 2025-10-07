package com.anrisys.team_flow.users.infrastructure.persistence.mapper;

import org.springframework.stereotype.Component;

import com.anrisys.team_flow.users.domain.model.User;
import com.anrisys.team_flow.users.infrastructure.persistence.entity.UserEntity;

@Component
public class UserMapper {
	public UserEntity toEntity(User user) {
		UserEntity entity = new UserEntity();
		entity.setPublicID(user.getId().getValue());
		entity.setEmail(user.getEmail());
		entity.setPasswordHash(user.getHashedPassword());
		entity.setFirstName(user.getFirstName());
		entity.setLastName(user.getLastName());
		entity.setRole(user.getRole());
		entity.setCreatedAt(user.getCreatedAt());
		entity.setUpdatedAt(user.getUpdatedAt());
		return entity;
	}

	public User toDomain(UserEntity entity) {
		return User.fromDB(
				entity.getPublicID().toString(), 
				entity.getEmail(), 
				entity.getPasswordHash(), 
				entity.getFirstName(), 
				entity.getLastName(), 
				entity.getRole(), 
				entity.getCreatedAt(), 
				entity.getUpdatedAt()
		);
	}
}
