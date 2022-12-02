package com.library.user.mapper;

import com.library.user.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    
    @Select("select * from user where id = #{id}")
    User findById(Long id);

    @Select("select * from user where card_id = #{card_id}")
    User findByCardId(Long card_id);
}