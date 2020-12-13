package com.levc.eos.security.component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Date;
import java.util.HashMap;

/**
 * jwt工具类
 * Create by Levc on 2020/10/22 : 3:21 上午
 */
public class JwtUtil {

    private Logger logger = LoggerFactory.getLogger(JwtUtil.class);

    private String createClaim(HashMap<String, Object> claims) {
        return Jwts.builder().setClaims(claims)
                // 1：加密算法，2：加密密钥
                .signWith(SignatureAlgorithm.HS512, "easy-office-system")
                .setExpiration(expirationDate())
                .compact();
    }

    public Date expirationDate() {
        // 3分钟过期
        return new Date(System.currentTimeMillis() * 1000 * 60 * 3);
    }

    public String createToken(UserDetails userDetails) {
        HashMap<String, Object> claimsMap = new HashMap<>();
        claimsMap.put("sub", userDetails.getUsername());
        claimsMap.put("rol", userDetails.getAuthorities());
        return createClaim(claimsMap);
    }

    // 校验token是否过期。
    public String validateToken(String token) {
        String username = null;
        try {
            Claims claims = Jwts.parser().setSigningKey("easy-office-system").parseClaimsJws(token).getBody();
            username = claims.getSubject();
        } catch (ExpiredJwtException e) {
            logger.warn("token过期");
        }
        return username;
    }
}
