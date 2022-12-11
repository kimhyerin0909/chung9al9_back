package com.ch9al9back.controller;

import com.ch9al9back.domain.User;
import com.ch9al9back.repository.UserRepository;
import com.ch9al9back.service.AuthService;
import com.ch9al9back.service.JwtService;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

@RestController
public class AuthController {

    @Resource(name = "userRepository")
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
        if(isUser != null) return "아이디 중복";
        else {
            authService.encodePW(user);
            userRepository.addUser(user);
            return jwtService.createJWT(user);
        }
    }

    @RequestMapping("/login") // 로그인
    public JSONObject Login(@RequestBody User user) throws Exception {
        Map<String, Object> isUser = userRepository.findById(user.getId());
        String pw = userRepository.pwCheck(user.getId());
        JSONObject result = new JSONObject();
        if(isUser == null) {
            result.put("success", false);
            result.put("message", "회원가입이 필요합니다.");
        }
        else if(!authService.encodePWForCheck(pw, user)) {
            result.put("success", false);
            result.put("message", "비밀번호가 틀렸습니다.");
        }
        else {
            result.put("success", true);
            result.put("token", jwtService.createJWT(user));
            result.put("info", isUser);
        };
        return result;
    }

    @RequestMapping(value = "/getUserInfo", method = RequestMethod.GET)
    public Map<String, Object> GetUserInfo(@RequestParam long user_id) throws Exception {
        return userRepository.findByUserId(user_id);
    }
}
