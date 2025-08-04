package com.emranhss.project.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Service;

@Service
public class JwtService {


  private final String SECRET_KEY="ax821scinOfcpxIoiLqYLQxyVTKrXuFhaU8bWW0FCOzDtmBLOK";


  //get all part from token
//    private Claims extractAllClaims(String token){
//        return Jwts
//                .parser()
//                .setSigningKey(String )
//    }
}
