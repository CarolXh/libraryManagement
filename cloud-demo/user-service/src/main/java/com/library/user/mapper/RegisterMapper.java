package com.library.user.mapper;

import com.library.user.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.sql.Timestamp;

public interface RegisterMapper {
    @Insert("insert into user(name, password, avatar, role, card_id, created_time, access) " +
            "values(#{name},#{password},#{avatar},#{role},#{card_id},#{created_time, jdbcType=TIMESTAMP},#{access})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    Long addUser(String name, String password, String avatar,
                 int role, Long card_id, Timestamp created_time, int access);

    @Select("select id, name, avatar from user where id = #{id}")
    User addHistory(Long id);

}
