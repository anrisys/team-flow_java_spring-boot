package com.anrisys.team_flow.users.infrastructure.persistence;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.anrisys.team_flow.users.domain.model.User;
import com.anrisys.team_flow.users.domain.repository.UserRepository;
import com.anrisys.team_flow.users.infrastructure.persistence.entity.UserEntity;
import com.anrisys.team_flow.users.infrastructure.persistence.mapper.UserMapper;
import com.anrisys.team_flow.users.infrastructure.persistence.repository.SpringDataUserRepository;

@Repository
public class JpaUserRepository implements UserRepository{
	
	private final SpringDataUserRepository springDataRepo;
	private final UserMapper userMapper;

	public JpaUserRepository(SpringDataUserRepository springDataRepo, UserMapper userMapper) {
		super();
		this.springDataRepo = springDataRepo;
		this.userMapper = userMapper;
	}

	@Override
	public User save(User user) {
		UserEntity entity = userMapper.toEntity(user);
		UserEntity savedEntity = springDataRepo.save(entity);
		return userMapper.toDomain(savedEntity);
	}
	
    @Override
    public Optional<User> findByEmail(String email) {
        return springDataRepo.findByEmail(email)
                           .map(userMapper::toDomain);
    }
    
    @Override
    public boolean existsByEmail(String email) {
        return springDataRepo.existsByEmail(email);
    }
	
}
