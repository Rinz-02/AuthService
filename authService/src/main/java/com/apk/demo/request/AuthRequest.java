package com.apk.demo.request;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthRequest 
{
	private Long id;
	private String email;
	private String password;
}
