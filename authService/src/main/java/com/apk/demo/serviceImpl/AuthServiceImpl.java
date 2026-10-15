package com.apk.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
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
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	//login
	@Override
	public boolean login(AuthRequest request) 
	{
		try
		{
			User user = authRepo.findByEmail(request.getEmail());
			if(passwordEncoder.matches(request.getPassword(), user.getPassword()))
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

	//findAll
	@Override
	public List<AuthResponse> findAll() 
	{	 
		List<User> users = authRepo.findAll();
		System.out.print("Size" + users);
		return authRepo.findAll().stream().map(UserMapper:: toResponse).toList();
	}

	//create
	@Override
	public AuthResponse register(AuthRequest request) 
	{
		User user = UserMapper.toEntity(request);
		user.setPassword(passwordEncoder.encode(request.getPassword()));
		authRepo.save(user);
		return UserMapper.toResponse(user);
	}

	//findById
	@Override
	public User findById(Long id) 
	{
		return authRepo.findById(id).get();
	}

	//update
	@Override
	public User update(AuthRequest request) 
	{
		User existing = authRepo.findById(request.getId())
				.orElseThrow(() -> new RuntimeException("User not Found"));
		
		existing.setEmail(request.getEmail());
		existing.setPassword(request.getPassword());
		return authRepo.save(existing);
	}

	@Override
	public boolean delete(Long id) {
		
		if(authRepo.existsById(id))
		{
			 authRepo.deleteById(id);
			 return true;
		}else {
			return false;
		}
				
	}


}
