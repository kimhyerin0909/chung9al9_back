package com.ch9al9back.repository;

import com.ch9al9back.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
@Mapper
public interface UserRepository {
    @Insert("insert into User values (0, #{id}, #{pw}, #{nickname}, '0', 0, #{lat}, #{lon})")
    void addUser(User user);

    @Select("select * from User where id = #{id}")
    Map<String, Object> findById(String id);

    @Select("select pw from User where id = #{id}")
    String pwCheck(String id);

}
