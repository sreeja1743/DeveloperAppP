package com.app.dca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.dca.entity.UserD;

@Repository
public interface IUserRepository extends JpaRepository<UserD,String>{
	
	UserD login(UserD user);
	
	UserD logout(UserD user);
}