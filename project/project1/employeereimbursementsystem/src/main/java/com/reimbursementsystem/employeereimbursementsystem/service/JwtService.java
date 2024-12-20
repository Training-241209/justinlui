// package com.reimbursementsystem.employeereimbursementsystem.service;

// import com.reimbursementsystem.employeereimbursementsystem.entity.Account;
// import io.jsonwebtoken.Jwts;
// import io.jsonwebtoken.SignatureAlgorithm;
// import io.jsonwebtoken.Jwts.KEY;

// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.stereotype.Service;


// import java.util.Date;
// @Service
// public class JwtService {
//     @Value("${jwt.secret}")
//     private String secretKey;

//     public KEY getSigningKey(){
//         return 
//     }
//     public String generateToken(Account account) {
//         return Jwts.builder()
//                 .claim("id", account.getAccountId())
//                 .claim("email", account.getUserName())
//                 // Add other fields
//                 .issuedAt(new Date(System.currentTimeMillis()))
//                 .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 15)) // 15 minutes
//                 .signWith(getSigningKey())
//                 .compact();
//     }

//     public Account decodeToken(String token) {
//         var claims = Jwts.parser()
//                 .verifyWith(getPublicSigningKey())
//                 .build()
//                 .parseSignedClaims(token)
//                 .getPayload();
//                 Account account = new Account();
//                 account.setAccountId(claims.get("id", Integer.class)); 
//                 account.setUsername(claims.get("email", String.class));
//         return account;
//     }
    