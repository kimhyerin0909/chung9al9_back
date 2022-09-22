package com.ch9al9back.controller;

import com.ch9al9back.domain.Enterpriser;
import com.ch9al9back.repository.BossRepository;
import com.ch9al9back.service.AuthService;
import com.ch9al9back.service.BossJwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/enter")
public class BossController {
    @Autowired
    private BossRepository bossRepository;
    @Autowired
    private BossJwtService bossJwtService;
    @Autowired
    private AuthService authService;

    @RequestMapping("/join")
    public String Join(@RequestBody Enterpriser enter) throws Exception {
        Map<String, Object> isUser = bossRepository.findById(enter.getId());
        if(isUser != null) return "아이디 중복";
        else {
            authService.encodeBossPW(enter);
            bossRepository.addBoss(enter);
            return bossJwtService.createJWT(enter);
        }
    }

    @RequestMapping("/login")
    public String Login(@RequestBody Enterpriser enter) throws Exception {
        Map<String, Object> isUser = bossRepository.findById(enter.getId());
        String pw = bossRepository.pwCheck(enter.getId());
        if(isUser == null) return "회원가입 필요";
        else if(!authService.encodeBossPWForCheck(pw, enter)) return "비밀번호 틀림";
        else return bossJwtService.createJWT(enter);
    }
}
