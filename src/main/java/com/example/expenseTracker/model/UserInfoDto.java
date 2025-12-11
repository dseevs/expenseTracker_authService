package com.example.expenseTracker.model;



import com.example.expenseTracker.entity.UserInfo;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming (PropertyNamingStrategy.SnakeCaseStrategy.class)
public class UserInfoDto  extends UserInfo{
	private String firstName;
	private String lastName;
	private Long phoneNumber;
	private String email;


}



