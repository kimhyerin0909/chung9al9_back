package com.ch9al9back.controller;

import com.ch9al9back.domain.User;
import com.ch9al9back.repository.UserRepository;
import com.ch9al9back.service.AuthService;
import com.ch9al9back.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class AuthController {
    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private AuthService authService;

    public AuthController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping("/join") // 회원가입
    public String Join(@RequestBody User user) throws Exception {
        Map<String, Object> isUser = userRepository.findById(user.getId());
        if(isUser != null) return "이미 가입된 회원입니다.";
        else {
            authService.encodePW(user);
            userRepository.addUser(user);
            return jwtService.createJWT(user);
        }
    }

    @RequestMapping("/login") // 로그인
    public String Login(@RequestBody User user) throws Exception {
        Map<String, Object> isUser = userRepository.findById(user.getId());
        String pw = userRepository.pwCheck(user.getId());
        if(isUser == null) return "회원가입 필요";
        else if(!authService.encodePWForCheck(pw, user)) return "비밀번호 틀림";
        else return jwtService.createJWT(user);
    }
}
