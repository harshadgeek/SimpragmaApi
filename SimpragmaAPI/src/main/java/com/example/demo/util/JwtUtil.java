package com.example.demo.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtUtil {
	private String SECRECT_KEY = "secret";
	
	public String extractUserName(String token) {
		return extractClaim(token,Claims::getSubject);
	}
    
	public Date extractExpiration(String token) {
		return extractClaim(token,Claims::getExpiration);
	}
	
	public <T> T extractClaim(String token,Function<Claims, T> claimsResolver) {
		final Claims claims = extractAllClaims(token);
		return claimsResolver.apply(claims);
	}
	private Claims extractAllClaims(String token) {
		return Jwts.parser().setSigningKey(SECRECT_KEY).parseClaimsJws(token).getBody();
	}
	private Boolean isTokenExpired(String token) {
		return extractExpiration(token).before(new Date());
	}
	public String generateToken(User userDetails) {
		Map<String, Object> claims = new HashMap<>();
		return createToken(claims,userDetails.getUserName());
	}
	
	private String createToken(Map<String, Object> claims,String subject) {
		return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis())).setExpiration(new Date(System.currentTimeMillis() + 1000 *60 * 60 *10)).signWith(SignatureAlgorithm.HS256, SECRECT_KEY).compact();
	}
	
	public Boolean validateToken(String token,User userDetails) {
		final String userName = extractUserName(token);
		return (userName.equals(userDetails.getUserName()) && !isTokenExpired(token));
	}
	
}