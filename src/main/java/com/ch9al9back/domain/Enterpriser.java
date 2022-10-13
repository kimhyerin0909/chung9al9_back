package com.ch9al9back.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
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
    private double lat;
    private double lon;
    public Enterpriser(int en_id, String id, String pw, String en_num, String comp_name, String captain, String address, String phone, double lat, double lon) {
        this.en_id = en_id;
        this.id = id;
        this.pw = pw;
        this.en_num = en_num;
        this.comp_name = comp_name;
        this.captain = captain;
        this.address = address;
        this.phone = phone;
        this.lat = lat;
        this.lon = lon;
    }
}
