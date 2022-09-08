package com.ch9al9back.controller;

import com.ch9al9back.domain.User;
import com.ch9al9back.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {
    private final UserRepository userRepository;

    public AuthController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping(value = "/join", method = RequestMethod.POST)
    public void Join(@RequestBody User user) throws Exception {
        // 회원가입
        System.out.println(user);
        userRepository.addUser(user);
    }

    @RequestMapping("/login")
    public void Login(@ModelAttribute User user) throws Exception {
        // 로그인
    }
}
