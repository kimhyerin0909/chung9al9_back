package com.ch9al9back.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Diary {
    private long cal_id;
    private long user_id;
    private String date;
    private String start_time;
    private String end_time;
    private String hour;
    private int salary;

    public Diary(long cal_id, long user_id, String date, String start_time, String end_time, String hour, int salary) {
        this.cal_id = cal_id;
        this.user_id = user_id;
        this.date = date;
        this.start_time = start_time;
        this.end_time = end_time;
        this.hour = hour;
        this.salary = salary;
    }
}
