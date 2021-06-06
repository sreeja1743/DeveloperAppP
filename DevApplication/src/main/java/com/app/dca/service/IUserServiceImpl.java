package com.app.dca.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dca.entity.Userdeveloper;
import com.app.dca.repository.UserRepository;

@Service
public class IUserServiceImpl implements IUserService{
	
	@Autowired
	private UserRepository repu;



	@Override
	public Userdeveloper login(Userdeveloper user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Userdeveloper logout(Userdeveloper user) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
