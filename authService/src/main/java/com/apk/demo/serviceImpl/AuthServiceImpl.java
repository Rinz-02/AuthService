package com.apk.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apk.demo.mapper.UserMapper;
import com.apk.demo.model.User;
import com.apk.demo.repository.AuthRepository;
import com.apk.demo.request.AuthRequest;
import com.apk.demo.response.AuthResponse;
import com.apk.demo.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService 
{
	@Autowired
	private AuthRepository authRepo;
	
	@Override
	public boolean findByEmail(AuthRequest request) 
	{
		try
		{
			User user = authRepo.findByEmail(request.getEmail());
			if(user.getPassword().equals(request.getPassword())  && user != null)
			{
				return true;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public List<AuthResponse> findAll() 
	{	 
		List<User> users = authRepo.findAll();
		System.out.print("Size" + users);
		return authRepo.findAll().stream().map(UserMapper:: toResponse).toList();
	}


}
