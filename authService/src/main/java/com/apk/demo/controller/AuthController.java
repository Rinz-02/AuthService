package com.apk.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apk.demo.model.User;
import com.apk.demo.request.AuthRequest;
import com.apk.demo.response.AuthResponse;
import com.apk.demo.service.AuthService;

import io.swagger.v3.oas.annotations.Operation;

import java.util.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:5173")
public class AuthController 
{
	@Autowired
	private AuthService authService;
	
	
	//Login
	@PostMapping("/login")
	@Operation(summary = "Auth Users", 
    description = "Login")
	public ResponseEntity<?> auth(@RequestBody AuthRequest request)
	{
		try 
		{
			return ResponseEntity.ok(authService.login(request));
		} catch (RuntimeException e) 
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("message", e.getMessage()));
		}
		
	}
	
	//FindAll
	@GetMapping("/findAll")
	@Operation(summary = "Find All Users", 
    description = "Find All")
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
	
	//Create
	@PostMapping("/register")
	@Operation(summary = "Create User", 
    description = "Register")
	public ResponseEntity<?> register(@RequestBody AuthRequest request)
	{
		try {
			return ResponseEntity.ok(authService.register(request));
		}catch(RuntimeException e)
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("message", e.getMessage()));
		}
				
		
	}
	
	//Update
	@GetMapping("/findById/{id}")
	@Operation(summary = "Find User By Id",
	description = "Find By Id")
	public ResponseEntity<?> findById(@PathVariable Long id)
	{
		try {
			return ResponseEntity.ok(authService.findById(id));
			
		}catch(RuntimeException e)
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("message", e.getMessage()));
		}
	}
	
	@PutMapping("/update")
	@Operation(summary = "Update",
	description = "Update By Id")
	public ResponseEntity<?> update(@RequestBody AuthRequest req)
	{
		try {
			return ResponseEntity.ok(authService.update(req));
		}catch(RuntimeException e)
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("message", e.getMessage()));
		}
	}
	
	//Delete
	@DeleteMapping("/delete/{id}")
	@Operation(summary = "Delete",
	description = "Delete By Id")
	public ResponseEntity<?> delete(@PathVariable Long id)
	{
		try {
			return ResponseEntity.ok(authService.delete(id));
		}catch(RuntimeException e)
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("message", e.getMessage()));
		}
	}
}
