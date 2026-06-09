package com.apk.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.apk.demo.model.User;

public interface AuthRepository extends JpaRepository<User,Long> 
{
	public User findByEmail(String email);
}
