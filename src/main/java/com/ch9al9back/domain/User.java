package com.ch9al9back.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class User {
    private int user_id;
    private String id;
    private String pw;
    private String nickname;
    private double lat;
    private double lon;

    public User(int user_id, String id, String pw, String nickname, double lat, double lon) {
        this.user_id = user_id;
        this.id = id;
        this.pw = pw;
        this.nickname = nickname;
        this.lat = lat;
        this.lon = lon;
    }

}
