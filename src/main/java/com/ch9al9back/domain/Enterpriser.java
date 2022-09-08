package com.ch9al9back.domain;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Enterpriser {
    private int en_id;
    private String id;
    private String pw;
    private String en_num;
    private String comp_name;
    private String captain;
    private String address;
    private String phone;
    public Enterpriser(int en_id, String id, String pw, String en_num, String comp_name, String captain, String address, String phone) {
        this.en_id = en_id;
        this.id = id;
        this.pw = pw;
        this.en_num = en_num;
        this.comp_name = comp_name;
        this.captain = captain;
        this.address = address;
        this.phone = phone;
    }
}
