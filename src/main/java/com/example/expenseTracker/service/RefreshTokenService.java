package com.example.expenseTracker.service;



import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.expenseTracker.entity.RefreshToken;
import com.example.expenseTracker.entity.UserInfo;
import com.example.expenseTracker.repository.RefreshTokenRepository;
import com.example.expenseTracker.repository.UserRepository;

@Service

public class RefreshTokenService {
	@Autowired
	RefreshTokenRepository refreshTokenRepository;
	@Autowired
	UserRepository userRepository;

	public RefreshToken createRefreshToken(String username) {
		UserInfo userInfoExtracted = userRepository.findByUsername(username);
		RefreshToken refreshToken = RefreshToken.builder().userInfo(userInfoExtracted)
				.token(UUID.randomUUID().toString()).expiryDate(Instant.now().plusMillis(600000)).build();
		return refreshTokenRepository.save(refreshToken);
	}

	public Optional<RefreshToken> findByToken(String token) {
		return refreshTokenRepository.findByToken(token);
	}

	public RefreshToken verifyExpiration(RefreshToken token) {
		if (token.getExpiryDate().compareTo(Instant.now()) < 0) {
			refreshTokenRepository.delete(token);
			throw new RuntimeException(token.getToken() + "Refresh Token is expired. Please make a new login");

		}
		return token;
	}

}
