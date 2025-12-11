package com.example.expenseTracker.repository;



import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.expenseTracker.entity.RefreshToken;

public interface RefreshTokenRepository extends CrudRepository<RefreshToken, Integer>{

	Optional <RefreshToken> findByToken(String token);
}
