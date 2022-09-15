package com.ch9al9back.service;

import com.ch9al9back.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private PasswordEncoder passwordEncoder;

    public void encodePW(User user) {
        String enPw = passwordEncoder.encode(user.getPw());
        System.out.println(enPw);
        user.setPw(enPw);
    }
}
