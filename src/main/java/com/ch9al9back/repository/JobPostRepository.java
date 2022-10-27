package com.ch9al9back.repository;

import com.ch9al9back.domain.JobPost;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface JobPostRepository {
    @Insert("insert into JobPost values (0, #{comp_id}, #{title}, #{write_time}, #{day}, #{time}, #{period}, #{salary_unit}, #{salary}, #{gender}, #{age}, #{priority})")
    void addJobPost(JobPost jobPost);

    @Select("select J.*, E.comp_name, E.captain, E.address, E.phone from JobPost J, Enterpriser E\n" +
            "where comp_id in\n"+
            "(select en_id from Enterpriser\n"+
            "where ST_DISTANCE_SPHERE(POINT(#{lon}, #{lat}),POINT(lon,lat)) <= #{distance})\n" +
            "AND J.comp_id = E.en_id\n"+
            "order by write_time desc;")
    List<JobPost> getPostByLatLon(double lat, double lon, int distance);

    @Select("select J.*, E.comp_name, E.captain, E.address, E.phone from JobPost J, Enterpriser E\n"+
            "where post_id = #{post_id} and J.comp_id = E.en_id;")
    JobPost findDetailById(long post_id);
}
