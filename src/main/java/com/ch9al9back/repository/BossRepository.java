package com.ch9al9back.repository;

import com.ch9al9back.domain.Enterpriser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
@Mapper
public interface BossRepository {
    @Insert("insert into Enterpriser values (0, #{id}, #{pw}, #{en_num}, #{comp_name}, #{captain}, #{address}, #{phone})")
    void addBoss(Enterpriser enter);
    @Select("select * from Enterpriser where id = #{id}")
    Map<String, Object> findById(String id);

    @Select("select pw from Enterpriser where id = #{id}")
    String pwCheck(String id);

    @Select("select en_num from Enterpriser where id = #{id}")
    String enterCheck(String id);
}
