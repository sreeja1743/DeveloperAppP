package com.app.dca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.dca.entity.Userdeveloper;

public interface UserRepository extends JpaRepository<Userdeveloper, String>{

}
