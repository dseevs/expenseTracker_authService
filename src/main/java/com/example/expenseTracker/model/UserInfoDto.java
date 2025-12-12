package com.example.expenseTracker.model;



import com.example.expenseTracker.entity.UserInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming (PropertyNamingStrategy.SnakeCaseStrategy.class)
public class UserInfoDto  extends UserInfo{
	private String firstName;
	private String lastName;
	private Long phoneNumber;
	private String email;


}



