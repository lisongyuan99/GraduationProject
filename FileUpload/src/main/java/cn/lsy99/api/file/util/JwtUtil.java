package cn.lsy99.api.file.util;

import cn.lsy99.api.file.exception.exception.InvalidTokenException;
import cn.lsy99.api.file.exception.exception.TokenExpiredException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.spec.SecretKeySpec;
import java.io.Serializable;
import java.security.Key;
import java.util.Date;

@Component
@Slf4j
public class JwtUtil implements Serializable {

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
     *
     * @param id   数据库中主键id
     * @param role 用户角色
     * @return token
     */
    public static String generateToken(int id, int role) {
        // Map<String, Object> claims = new HashMap<>();
        // claims.put("role", String.valueOf(role));
        Key key = new SecretKeySpec(SECRET.getBytes(), SignatureAlgorithm.HS256.getJcaName());
        Date createdDate = new Date();
        Date expirationDate = calculateExpirationDate(createdDate);

        return Jwts.builder()
                .claim("role", String.valueOf(role))
                .setSubject(String.valueOf(id))
                .setIssuedAt(createdDate)
                .setExpiration(expirationDate)
                .signWith(key)
                .compact();
    }

    /**
     * 从token解出id和role并判断是否过期
     *
     * @param token token
     * @return token中信息
     */
    public static JwtInfo getInfoFromToken(String token) {
        try{
            Key key = new SecretKeySpec(SECRET.getBytes(), SignatureAlgorithm.HS256.getJcaName());
            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(key) // <---- publicKey, not privateKey
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
            int id = Integer.parseInt(claims.get("sub").toString());
            return JwtInfo.builder().id(id).build();
        } catch (ExpiredJwtException e){
            throw new TokenExpiredException();
        } catch (Exception e){
            throw new InvalidTokenException();
        }
    }

    /**
     * 计算过期时间
     *
     * @param createdDate token创建时间
     * @return 过期时间
     */
    public static Date calculateExpirationDate(Date createdDate) {
        return new Date(createdDate.getTime() + EXPIRATION * 1000);
    }

}
