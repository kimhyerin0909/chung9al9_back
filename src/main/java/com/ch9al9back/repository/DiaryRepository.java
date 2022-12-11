package com.ch9al9back.repository;

import com.ch9al9back.domain.Diary;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface DiaryRepository {
    @Insert("insert into Record values (0, #{user_id}, #{date}, #{start_time}, #{end_time}, #{hour}, #{salary})")
    void recordWork(Diary newRecord);

    @Select("select * from Record where user_id = #{user_id} and date=#{date}")
    Diary findByIdDate(long user_id, String date);

    @Select("select * from Record where user_id = #{user_id} and MONTH(date) = #{month}")
    List<Diary> findById(long user_id, int month);

    @Update("update Record set start_time = #{start_time}, end_time = #{end_time} where cal_id=#{cal_id}")
    void fixRecord(long cal_id, String start_time, String end_time);

    @Delete("delete from Record where cal_id = #{cal_id}")
    void deleteRecord(long cal_id);
}


