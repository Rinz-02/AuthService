package com.apk.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apk.demo.model.User;
import com.apk.demo.request.AuthRequest;
import com.apk.demo.response.AuthResponse;
import com.apk.demo.service.AuthService;
import java.util.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173")
public class AuthController 
{
	@Autowired
	private AuthService authService;
	
	@PostMapping("/auth")
	public ResponseEntity<?> auth(@RequestBody AuthRequest request)
	{
		try 
		{
			return ResponseEntity.ok(authService.findByEmail(request));
		} catch (RuntimeException e) 
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("message", e.getMessage()));
		}
		
	}
	
	@GetMapping("/auth")
	public ResponseEntity<?> findAll()
	{
		try 
		{	
			return ResponseEntity.ok(authService.findAll());
		} catch (RuntimeException e) 
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("message", e.getMessage()));
		}
	}
}
