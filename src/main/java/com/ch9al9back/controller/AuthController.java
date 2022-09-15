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

    @RequestMapping(value = "/join", method = RequestMethod.POST)
    public String Join(@RequestBody User user) throws Exception {
        // 회원가입
        Map<String, Object> isUser = userRepository.findById(user.getId());
        if(isUser != null) return "이미 가입된 회원입니다.";
        else {
            authService.encodePW(user);
            userRepository.addUser(user);
            return jwtService.createJWT(user);
        }
    }

    @RequestMapping("/login")
    public String Login(@RequestBody User user) throws Exception {
        // 로그인
        Map<String, Object> isUser = userRepository.findById(user.getId());
        if(isUser == null) return "회원가입 필요";
        else return jwtService.createJWT(user);
    }

    @RequestMapping("/pwtest")
    public void PwTest(@RequestBody User user) throws Exception {
        authService.encodePW(user);
    }
}
