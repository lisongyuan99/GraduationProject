package cn.lsy99.api.activity.organizer.util;

import cn.lsy99.api.activity.organizer.auth.dto.JwtInfo;
import cn.lsy99.api.activity.organizer.generator.UserRole;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.DefaultClock;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
@Slf4j
public class JwtUtil implements Serializable {

//    static final String CLAIM_KEY_USERNAME = "sub";
//    static final String CLAIM_KEY_CREATED = "iat";
    private final io.jsonwebtoken.Clock clock = DefaultClock.INSTANCE;

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private Long expiration;

    public JwtUtil() {
    }

    public String generateToken(int id, int role) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("role", String.valueOf(role));

        Date createdDate = clock.now();
        Date expirationDate = calculateExpirationDate(createdDate);

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(String.valueOf(id))
                .setIssuedAt(createdDate)
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    public JwtInfo getInfoFromToken(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
        int id = Integer.parseInt(claims.get("sub").toString());
        UserRole role = UserRole.values()[Integer.parseInt(claims.get("role").toString())];
        return JwtInfo.builder().id(id).role(role).build();
    }

    public Date calculateExpirationDate(Date createdDate) {
        return new Date(createdDate.getTime() + expiration * 1000);
    }


}
