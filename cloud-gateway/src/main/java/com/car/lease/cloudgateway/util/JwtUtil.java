package com.car.lease.cloudgateway.util;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.car.lease.cloudgateway.exception.JwtTokenMalformedException;
import com.car.lease.cloudgateway.exception.JwtTokenMissingException;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

@Component
public class JwtUtil {
	@Value("${jwt.secret}")
	private String jwtSecret;
	
	/*
	 * @Value("${jwt.token.validity}") private long tokenValidity;
	 */

	public Claims getClaims(final String token) {
		try {
			Claims body = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
			return body;
		} catch (Exception e) {
			System.out.println(e.getMessage() + " => " + e);
		}
		return null;
	}
	

	public void validateToken(final String header) throws JwtTokenMalformedException, JwtTokenMissingException {
		try {
			String[] parts = header.split(" ");
			
			  if (parts.length != 2 || !"Bearer".equals(parts[0])) { throw new
			  JwtTokenMalformedException("Incorrect Authentication Structure"); }
			 
			Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(parts[1]);
		} catch (SignatureException ex) {
			throw new JwtTokenMalformedException("Invalid JWT signature");
		} catch (MalformedJwtException ex) {
			throw new JwtTokenMalformedException("Invalid JWT token");
		} catch (ExpiredJwtException ex) {
			throw new JwtTokenMalformedException("Expired JWT token");
		} catch (UnsupportedJwtException ex) {
			throw new JwtTokenMalformedException("Unsupported JWT token");
		} catch (IllegalArgumentException ex) {
			throw new JwtTokenMissingException("JWT claims string is empty.");
		}
	}

}
