package com.app.dca.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dca.entity.Userdeveloper;
import com.app.dca.repository.UserRepository;

@Service
public class IUserServiceImpl implements IUserService{
	
	@Autowired
	private UserRepository repo;



	@Override
	public Userdeveloper login(Userdeveloper user){
		return null;
	}

	@Override
	public Userdeveloper logout(Userdeveloper user) {

		return null;
	}

	

}
