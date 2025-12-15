package com.example.expenseTracker.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.expenseTracker.entity.RefreshToken;
import com.example.expenseTracker.model.UserInfoDto;
import com.example.expenseTracker.response.JwtResponseDTO;
import com.example.expenseTracker.service.JwtService;
import com.example.expenseTracker.service.RefreshTokenService;
import com.example.expenseTracker.service.UserDetailsServiceImpl;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController

public class AuthController {
	@Autowired
	private JwtService jwtService;
	@Autowired
	private RefreshTokenService refreshTokenService;
	@Autowired
	private UserDetailsServiceImpl userDetailsService;

	@PostMapping("auth/v1/signup")
	public ResponseEntity SignUp(@RequestBody UserInfoDto userInfoDto) {
		try {
			Boolean isSignUped = userDetailsService.signupUser(userInfoDto);
			if (Boolean.FALSE.equals(isSignUped)) {
				return new ResponseEntity<>("Already Exist", HttpStatus.BAD_REQUEST);
			}
			RefreshToken refreshToken = refreshTokenService.createRefreshToken(userInfoDto.getUsername());
			String jwtToken = jwtService.GenerateToken(userInfoDto.getUsername());
			return new ResponseEntity<>(
					JwtResponseDTO.builder().accessToken(jwtToken).token(refreshToken.getToken()).build(),
					HttpStatus.OK);

		} catch (Exception ex) {
			ex.printStackTrace();
			return new ResponseEntity<>("Exception in User Service", HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}

}
