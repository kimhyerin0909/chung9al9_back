package com.ch9al9back.domain;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class User {
    private int user_id;
    private String id;
    private String pw;
    private String nickname;
    private String hour;
    private int salary;
    public User(int user_id, String id, String pw, String nickname, String hour, int salary) {
        this.user_id = user_id;
        this.id = id;
        this.pw = pw;
        this.nickname = nickname;
        this.hour = hour;
        this.salary = salary;
    }
}
