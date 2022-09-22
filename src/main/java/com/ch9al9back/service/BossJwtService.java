package com.ch9al9back.service;

import com.ch9al9back.domain.Enterpriser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

@Service
public class BossJwtService {
    private String key = "Cjdrn";

    public String createJWT(Enterpriser enter) {

        Map<String, Object> headers = new HashMap<>();
        headers.put("typ", "JWT");
        headers.put("alg", "HS256");

        Map<String, Object> payloads = new HashMap<>();
        payloads.put("en_id", enter.getEn_id());
        payloads.put("id", enter.getId());
        payloads.put("pw", enter.getPw());
        payloads.put("en_num", enter.getEn_num());
        payloads.put("comp_name", enter.getComp_name());
        payloads.put("captain", enter.getCaptain());
        payloads.put("address", enter.getAddress());
        payloads.put("phone", enter.getPhone());

        String accessToken = Base64.getEncoder().encodeToString(key.getBytes());

        return  Jwts.builder()
                .setHeader(headers)
                .setClaims(payloads)
                .signWith(SignatureAlgorithm.HS256, accessToken)
                .compact();
    }
}