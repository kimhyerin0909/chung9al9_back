package com.ch9al9back.service;

import com.ch9al9back.domain.Enterpriser;
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

    public boolean encodePWForCheck(String cuPw, User user) {
        return passwordEncoder.matches(user.getPw(), cuPw);
    }
    public void encodeBossPW(Enterpriser enter) {
        String enPw = passwordEncoder.encode(enter.getPw());
        enter.setPw(enPw);
    }

    public boolean encodeBossPWForCheck(String cuPw, Enterpriser enter) {
        return passwordEncoder.matches(enter.getPw(), cuPw);
    }

}
