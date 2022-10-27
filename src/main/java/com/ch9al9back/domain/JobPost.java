package com.ch9al9back.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class JobPost {
    private long post_id; // 게시글 아이디
    private long comp_id; // 회사 아이디
    private String title; // 공고 제목
    private String write_time; // 작성 날짜
    private String day; // 근무 요일
    private String time; // 근무 시간
    private String period; // 근무 기간
    private int salary_unit; // 1:시급 2:일급 3:주급 4:월급 5:연봉
    private int salary; // 급여
    private int gender; // 1:무관 2:여자 3:남자
    private int age; // 1: 무관
    private String priority; // 우대조건
    private String comp_name;
    private String captain;
    private String address;
    private String phone;

    public JobPost(long post_id, long comp_id, String title, String write_time, String day, String time, String period, int salary_unit, int salary, int gender, int age, String priority, String comp_name, String captain, String address, String phone) {
        this.post_id = post_id;
        this.comp_id = comp_id;
        this.title = title;
        this.write_time = write_time;
        this.day = day;
        this.time = time;
        this.period = period;
        this.salary_unit = salary_unit;
        this.salary = salary;
        this.gender = gender;
        this.age = age;
        this.priority = priority;
        this.comp_name = comp_name;
        this.captain = captain;
        this.address = address;
        this.phone = phone;
    }
}
