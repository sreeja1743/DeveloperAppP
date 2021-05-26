package com.app.dca.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dca.entity.UserD;
import com.app.dca.repository.IUserRepository;
import com.app.dca.repository.UserRepository;

@Service
public class IUserServiceImpl implements IUserService{
	
	@Autowired
	private IUserRepository repu;
	public IUserRepository getRepu() {
		return repu;
	}

	public void setRepu(IUserRepository repu) {
		this.repu = repu;
	}

	@Override
	public UserD login(UserD user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserD logout(UserD user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserD addUser(UserD u) {
		// TODO Auto-generated method stub
		return ;
	}

	@Override
	public UserD editUser(UserD u) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserD getUser(int userid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserD removeUser(int userid) {
		// TODO Auto-generated method stub
		return null;
	}

}
