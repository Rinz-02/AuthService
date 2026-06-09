package com.apk.demo.mapper;

import com.apk.demo.model.User;
import com.apk.demo.request.AuthRequest;
import com.apk.demo.response.AuthResponse;

public class UserMapper 
{
	public static AuthResponse toResponse(User user)
	{
		return AuthResponse.builder()
				.id(user.getId())
				.email(user.getEmail())
				.password(user.getPassword())
				.build();
	}
	
	public static User toEntity(AuthRequest request)
	{
		return User.builder()
				.email(request.getEmail())
				.password(request.getPassword())
				.build();
	}
}
