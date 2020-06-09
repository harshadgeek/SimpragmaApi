package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.AuthenicatResponse;
import com.example.demo.model.User;
import com.example.demo.service.MyUserDetailsService;
import com.example.demo.util.JwtUtil;

@RestController
public class UserController {
	
	@Autowired
	private MyUserDetailsService myUserDetailsService;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@PostMapping(value="/login")
	public ResponseEntity<AuthenicatResponse> login(@RequestBody User user) throws Exception {
		User userDetails = myUserDetailsService.getuserByUserName(user.getUserName());
		
		String jwt = jwtUtil.generateToken(userDetails);
		
		return ResponseEntity.status(HttpStatus.OK).body(new AuthenicatResponse("success", jwt));
	}
	@PostMapping("/register")
	public ResponseEntity<String> registration(@RequestBody User user) throws Exception{
		myUserDetailsService.saveuserName(user);
		return ResponseEntity.status(HttpStatus.CREATED).body("new user created");
	}
}
