package com.example.expenseTracker.repository;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.expenseTracker.entity.UserInfo;

@Repository
public interface UserRepository extends CrudRepository<UserInfo, String> {
	public UserInfo findByUsername(String username);

}
