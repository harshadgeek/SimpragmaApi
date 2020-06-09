package com.example.demo.model;

public class AuthenicatResponse {

	private String message;
	private String accessToken;
	
	
	public AuthenicatResponse() {
		// TODO Auto-generated constructor stub
	}
	
	
	public AuthenicatResponse(String message, String accessToken) {
		super();
		this.message = message;
		this.accessToken = accessToken;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	
	
	
	
}
