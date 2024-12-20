package com.reimbursementsystem.employeereimbursementsystem.service;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.reimbursementsystem.employeereimbursementsystem.entity.Account;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
@Service
public class JwtService {
    @Value("${jwt.secret}")
    private String secretKey;

    
    private SecretKey getSigningKey() {
        return Keys.hmacShaKeyFor(secretKey.getBytes());
    }
    public String generateToken(Account account) {
        return Jwts.builder()
                .claim("id", account.getAccountId())
                .claim("email", account.getUserName())
                // Add other fields
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 15)) // 15 minutes
                .signWith(getSigningKey())
                .compact();
    }

    public Account decodeToken(String token) {
        var claims = Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
                Account account = new Account();
                account.setAccountId(claims.get("id", Integer.class)); 
                account.setUsername(claims.get("email", String.class));
        return account;
    }
}
    