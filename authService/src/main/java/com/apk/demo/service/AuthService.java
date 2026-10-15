package com.apk.demo.service;

import java.util.List;

import org.jspecify.annotations.Nullable;

import com.apk.demo.model.User;
import com.apk.demo.request.AuthRequest;
import com.apk.demo.response.AuthResponse;


public interface AuthService 
{
	public boolean login(AuthRequest request);
	
	public List<AuthResponse> findAll();
	
	public AuthResponse register(AuthRequest request);

	public User findById(Long id);

	public User update(AuthRequest request);

	public boolean  delete(Long id);
	

	
}
