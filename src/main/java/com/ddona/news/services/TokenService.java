package com.ddona.news.services;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collections;
import java.util.Date;

public class TokenService {

    private static final long EXPIRE_DATE = 864000000;
    private static final String MY_KEY = "L2005Web";
    private static final String TOKEN_PREFIX = "Bearer ";
    private static final String HEADER_KEY = "Authorization";

    public static void addHeader(HttpServletResponse response, String username) {
        String jwtKey = Jwts.builder()
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE_DATE))
                .signWith(SignatureAlgorithm.HS512, MY_KEY)
                .compact();
        response.addHeader(HEADER_KEY, TOKEN_PREFIX + jwtKey);
    }

    public static Authentication getAuthen(HttpServletRequest request) {
        String token = request.getHeader(HEADER_KEY);
        if (!token.isEmpty()) {
            String user = Jwts.parser().setSigningKey(MY_KEY)
                    .parseClaimsJws(token.replace(TOKEN_PREFIX, "")).getBody().getSubject();
            return user == null ? null :
                    new UsernamePasswordAuthenticationToken(user, null, Collections.emptyList());
        }
        return null;
    }
}
