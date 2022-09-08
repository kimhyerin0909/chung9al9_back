package com.ch9al9back.repository;

import com.ch9al9back.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserRepository {
    @Insert("insert into User values (#{user_id}, #{id}, #{pw}, #{nickname}, #{hour}, #{salary})")
    void addUser(User user);
}
