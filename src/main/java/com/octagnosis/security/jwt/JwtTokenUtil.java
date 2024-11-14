package com.octagnosis.security.jwt;

import com.octagnosis.api.user.domain.RoleEnum;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtTokenUtil {
    private final String SECRET_KEY = "039394a11762fb4b47df120ee2cbfd6666ab6b66ce34c8d5bbe72316ac149bd477781e174196499674059e335ba342d8d19b0a107f3b23cf35dd9cd95b07439c";
    private final long ACCESS_TOKEN_EXPIRE_TIME = 3600000; // 1 hour
    private final long REFRESH_TOKEN_EXPIRE_TIME = 3600000 * 24; // 1 day

    private String createToken(String username, RoleEnum role, long expiration) {
        Date now = new Date();
        Date validity = new Date(now.getTime() + expiration);

        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        Key key = Keys.hmacShaKeyFor(keyBytes);

        Claims claims = Jwts.claims().setSubject(username);
        claims.put("role", role);

        return Jwts.builder()
                .setSubject(username)
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(validity)
                .signWith(key)
                .compact();
    }

    public String createAccessToken(String username, RoleEnum role) {
        return createToken(username, role, ACCESS_TOKEN_EXPIRE_TIME);
    }

    public String createRefreshToken(String username, RoleEnum role) {
        return createToken(username, role, REFRESH_TOKEN_EXPIRE_TIME);
    }

    public String getUsernameFromToken(String token) {
        return Jwts.parserBuilder().setSigningKey(SECRET_KEY).build().parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(SECRET_KEY).build().parseClaimsJws(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }
}
