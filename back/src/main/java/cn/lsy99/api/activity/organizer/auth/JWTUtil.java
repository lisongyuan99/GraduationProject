package cn.lsy99.api.activity.organizer.auth;

import cn.lsy99.api.activity.organizer.auth.UserForAuth;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.DefaultClock;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.*;

@Component
public class JWTUtil implements Serializable {

    static final String CLAIM_KEY_USERNAME = "sub";
    static final String CLAIM_KEY_CREATED = "iat";
    private final io.jsonwebtoken.Clock clock = DefaultClock.INSTANCE;

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private Long expiration;

    public JWTUtil() {
    }

    public String generateToken(UserForAuth user) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", user.getUserId());
        claims.put("role", user.getOrganizer().getRole());
        return doGenerateToken(claims, user.getUsername());
    }

    public String doGenerateToken(Map<String, Object> claims, String subject) {
        final Date createdDate = clock.now();
        final Date expirationDate = calculateExpirationDate(createdDate);

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
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

    public String getUsernameFromToken(String token) {
        return getAllClaimsFromToken(token).get("sub").toString();
    }

    public int getUserIdFromToken(String token) {
        return Integer.parseInt(getAllClaimsFromToken(token).get("id").toString());
    }

    public Collection<? extends GrantedAuthority> getAuthoritiesFromToken(String token) {
        String[] roles = getAllClaimsFromToken(token).get("role").toString().split(",");
        Set<GrantedAuthority> authorities = new HashSet<>();
        for (String role : roles) {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.toUpperCase()));
        }
        return authorities;
    }

    public Date calculateExpirationDate(Date createdDate) {
        return new Date(createdDate.getTime() + expiration * 1000);
    }

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
