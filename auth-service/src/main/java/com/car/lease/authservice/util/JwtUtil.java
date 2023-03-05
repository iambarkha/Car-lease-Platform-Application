package com.car.lease.authservice.util;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.car.lease.authservice.exception.JwtTokenMalformedException;
import com.car.lease.authservice.exception.JwtTokenMissingException;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class JwtUtil {
	@Value("${jwt.secret}")
	private String jwtSecret;

	@Value("${jwt.token.validity}")
	private long tokenValidity;

	public Claims getClaims(final String token) {
		log.trace("Get claims for a token");
		try {
			Claims body = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
			return body;
		} catch (Exception e) {
			System.out.println(e.getMessage() + " => " + e);
			log.error("Error in getting claim");
		}
		return null;
	}

	public String generateToken(String id) {
		log.trace("Inside token generation");
		Claims claims = Jwts.claims().setSubject(id);
		long nowMillis = System.currentTimeMillis();
		long expMillis = nowMillis + tokenValidity;
		Date exp = new Date(expMillis);
		return Jwts.builder().setClaims(claims).setIssuedAt(new Date(nowMillis)).setExpiration(exp)
				.signWith(SignatureAlgorithm.HS512, jwtSecret).compact();
	}

	public void validateToken(final String header) throws JwtTokenMalformedException, JwtTokenMissingException {
		log.trace("Inside validate token");
		try {
			String[] parts = header.split(" ");
			
			  if (parts.length != 2 || !"Bearer".equals(parts[0])) {
				  log.error("Incorrect Authentication Structure");
				  throw new JwtTokenMalformedException("Incorrect Authentication Structure"); 
			  }
			 
			Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(parts[1]);
		} catch (SignatureException ex) {
			log.error("Exception while validating JWT token", ex);
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
