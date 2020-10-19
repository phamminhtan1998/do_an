package com.phamtan.do_an.jwt;

import com.phamtan.do_an.dao.entities.CustomerUserDetails;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtProvider {
    @Value("${jwt.secret}")
    private String JWT_SECRET_KEY ;
//    the time expired now we are using the milliseconds
//    the token i set will be expired after 5 minutes
    private long timeValidJwtKey = 5*60*1000 ;

//    create the jwt token  from user detals
    public String generateJwtToken(CustomerUserDetails userDetails){
        Date now = new Date();
        Date expriedJwtTime = new Date(now.getTime()+timeValidJwtKey);
//        create token
        String jwtToken = Jwts.builder()
                .setSubject(userDetails.getUsername())
                .setExpiration(expriedJwtTime)
                .setIssuedAt(now)
                .signWith(SignatureAlgorithm.HS512,JWT_SECRET_KEY)
                .compact();
        return jwtToken ;
    }

//    get user infomation from the token

    public String getUsernameFromToken(String authToken) {

            Claims claims = Jwts
                    .parser()
                    .setSigningKey(JWT_SECRET_KEY)
                    .parseClaimsJws(authToken)
                    .getBody();
            return claims.getSubject();

    }

//    validate jwt token
    public boolean validateJwtToken(String jwtToken){
        Date now = new Date();
        Date dateExperied = Jwts.parser().setSigningKey(JWT_SECRET_KEY).parseClaimsJws(jwtToken).getBody().getExpiration();
        if(dateExperied.after(now)){
            return true;
        }
        return false ;

    }
}
