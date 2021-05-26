package com.app.dca.service;

import com.app.dca.entity.UserD;

public interface IUserService {

	UserD login(UserD user);
	
	UserD logout(UserD user);

	UserD addUser(UserD u);

	UserD editUser(UserD u);

	UserD getUser(int userid);

	UserD removeUser(int userid);

}
