package com.apk.demo.service;

import java.util.List;

import com.apk.demo.model.User;
import com.apk.demo.request.AuthRequest;
import com.apk.demo.response.AuthResponse;


public interface AuthService 
{
	public boolean findByEmail(AuthRequest request);
	
	public List<AuthResponse> findAll();
	
}
