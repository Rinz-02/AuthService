package com.apk.demo.response;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthResponse 
{
	private Long id;
	private String email;
	private String password;
}
