package cn.lsy99.api.activity.util;

import cn.lsy99.api.activity.exception.exception.InvalidTokenException;
import cn.lsy99.api.activity.generator.UserRole;
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
    private static final io.jsonwebtoken.Clock clock = DefaultClock.INSTANCE;
    private static String SECRET;
    private static Long EXPIRATION;

    @Value("${jwt.secret}")
    public void setSECRET(String secret) {
        SECRET = secret;
    }

    @Value("${jwt.expiration}")
    public void setEXPIRATION(Long expiration) {
        EXPIRATION = expiration;
    }

    /**
     * 生成token
     * @param id 数据库中主键id
     * @param role 用户角色
     * @return token
     */
    public static String generateToken(int id, int role) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("role", String.valueOf(role));

        Date createdDate = clock.now();
        Date expirationDate = calculateExpirationDate(createdDate);

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(String.valueOf(id))
                .setIssuedAt(createdDate)
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();
    }

    /**
     * 从token解出id和role并判断是否过期
     * @param token token
     * @return token中信息
     */
    public static JwtInfo getInfoFromToken(String token) {
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(SECRET)
                    .parseClaimsJws(token)
                    .getBody();
            int id = Integer.parseInt(claims.get("sub").toString());
            UserRole role = UserRole.values()[Integer.parseInt(claims.get("role").toString())];
            // TODO 是否过期
            return JwtInfo.builder().id(id).role(role).build();
        } catch (Exception e) {
            throw new InvalidTokenException();
        }
    }

    /**
     * 计算过期时间
     * @param createdDate token创建时间
     * @return 过期时间
     */
    public static Date calculateExpirationDate(Date createdDate) {
        return new Date(createdDate.getTime() + EXPIRATION * 1000);
    }

}
