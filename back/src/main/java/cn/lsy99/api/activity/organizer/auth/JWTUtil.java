package cn.lsy99.api.activity.organizer.auth;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.DefaultClock;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

//import javax.crypto.Cipher;
//import javax.crypto.spec.IvParameterSpec;
//import javax.crypto.spec.SecretKeySpec;
// import java.security.AlgorithmParameters;

import java.io.Serializable;
import java.util.*;

@Component
@Slf4j
public class JWTUtil implements Serializable {

//    static final String CLAIM_KEY_USERNAME = "sub";
//    static final String CLAIM_KEY_CREATED = "iat";
    private final io.jsonwebtoken.Clock clock = DefaultClock.INSTANCE;

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private Long expiration;

    @Value("${organizer.type.org}")
    private int TYPE_ORG;

    @Value("${organizer.type.cert}")
    private int TYPE_CERT;

    public JWTUtil() {
    }

    public String generateToken(UserForAuth user) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("role", String.valueOf(user.getOrganizer().getType()));

        Date createdDate = clock.now();
        Date expirationDate = calculateExpirationDate(createdDate);

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(user.getUsername())
                .setIssuedAt(createdDate)
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    public Claims getAllClaimsFromToken(String token) {
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
    }

    public String getIdFromToken(String token) {
        return getAllClaimsFromToken(token).get("sub").toString();
    }

    public Collection<? extends GrantedAuthority> getAuthoritiesFromToken(String token) {
        int type = Integer.parseInt(getAllClaimsFromToken(token).get("role").toString());
        return getAuthoritiesFromType(type);
    }

    public Collection<? extends GrantedAuthority> getAuthoritiesFromType(int type){
        Set<GrantedAuthority> authorities = new HashSet<>();
        if (type == TYPE_ORG) {
            authorities.add(new SimpleGrantedAuthority("ROLE_ORG"));
        } else if (type == TYPE_CERT) {
            authorities.add(new SimpleGrantedAuthority("ROLE_ORG"));
            authorities.add(new SimpleGrantedAuthority("ROLE_ORG_CERT"));
        }
        return authorities;
    }


    public Date calculateExpirationDate(Date createdDate) {
        return new Date(createdDate.getTime() + expiration * 1000);
    }

//    public static String decrypt(String data, String key, String iv, String encodingFormat)  {
//
//        Base64.Decoder decoder = Base64.getDecoder();
//        //被加密的数据
//        byte[] dataByte = decoder.decode(data);
//        //加密秘钥
//        byte[] keyByte = decoder.decode(key);
//        //偏移量
//        byte[] ivByte = decoder.decode(iv);
//
//
//        try {
//            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
//
//            SecretKeySpec spec = new SecretKeySpec(keyByte, "AES");
//            AlgorithmParameters parameters = AlgorithmParameters.getInstance("AES");
//            parameters.init(new IvParameterSpec(ivByte));
//            cipher.init(Cipher.DECRYPT_MODE, spec, parameters);// 初始化
//
//            byte[] resultByte = cipher.doFinal(dataByte);
//            if (null != resultByte && resultByte.length > 0) {
//                return new String(resultByte, encodingFormat);
//            }
//            return null;
//        } catch (Exception e){
//            e.printStackTrace();
//        }
//
//        return null;
//    }


//    public Collection<? extends GrantedAuthority> getAuthorities() {

//    }

    //    public String getUsernameFromToken(String token) {
//        return getClaimFromToken(token, Claims::getSubject);
//    }
//
//    public Date getIssuedAtDateFromToken(String token) {
//        return getClaimFromToken(token, Claims::getIssuedAt);
//    }
//
//    public Date getExpirationDateFromToken(String token) {
//        return getClaimFromToken(token, Claims::getExpiration);
//    }
//
//    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
//        final Claims claims = getAllClaimsFromToken(token);
//        return claimsResolver.apply(claims);
//    }
//
//    public <T> T getClaimFromToken(String token, String claimName, Class<T> requiredType) {
//        final Claims claims = getAllClaimsFromToken(token);
//        return claims.get(claimName, requiredType);
//    }
//
//
//
//    public Boolean isTokenExpired(String token) {
//        final Date expiration = getExpirationDateFromToken(token);
//        return expiration.before(clock.now());
//    }
//
//    public Boolean isCreatedBeforeLastPasswordReset(Date created, Date lastPasswordReset) {
//        return (lastPasswordReset != null && created.before(lastPasswordReset));
//    }
//
//    public Boolean ignoreTokenExpiration(String token) {
//        // here you specify tokens, for that the expiration is ignored
//        return false;
//    }
//


    //
//    public Boolean canTokenBeRefreshed(String token, Date lastPasswordReset) {
//        final Date created = getIssuedAtDateFromToken(token);
//        return !isCreatedBeforeLastPasswordReset(created, lastPasswordReset)
//                && (!isTokenExpired(token) || ignoreTokenExpiration(token));
//    }
//
//    public String refreshToken(String token) {
//        final Date createdDate = clock.now();
//        final Date expirationDate = calculateExpirationDate(createdDate);
//
//        final Claims claims = getAllClaimsFromToken(token);
//        claims.setIssuedAt(createdDate);
//        claims.setExpiration(expirationDate);
//
//        return Jwts.builder()
//                .setClaims(claims)
//                .signWith(SignatureAlgorithm.HS512, secret)
//                .compact();
//    }
//
//    public Boolean validateToken(String token, String username) {
//        final String subject = getUsernameFromToken(token);
////        final Date created = getIssuedAtDateFromToken(token);
////        final Date expiration = getExpirationDateFromToken(token);
//        return (
//                subject.equals(username)
//                        && !isTokenExpired(token)
////                && !isCreatedBeforeLastPasswordReset(created, user.getLastPasswordResetDate())
//        );
//    }
//

}
