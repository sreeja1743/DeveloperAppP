package com.app.dca.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dca.entity.UserD;
import com.app.dca.repository.IUserRepository;

@Service
public class IUserServiceImpl implements IUserService{
	@Autowired
	private IUserRepository repo;
	@Override
	@Transactional
	public UserD login(UserD user) {
		// TODO Auto-generated method stub
		repo.save(user);
		return user;
	}

	@Override
	public UserD logout(UserD user) {
		// TODO Auto-generated method stub
		return null;
	}

	public IUserRepository getRepo() {
		return repo;
	}

	public void setRepu(IUserRepository repo) {
		this.repo = repo;
	}
}