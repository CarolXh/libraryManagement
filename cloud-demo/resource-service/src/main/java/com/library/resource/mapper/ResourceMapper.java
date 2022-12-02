package com.library.resource.mapper;

import com.library.resource.pojo.Resource;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

public interface ResourceMapper {

    @Select("select * from resource where id = #{id}")
    Resource findById(Long id);

    @Select("select * from resource where access = #{access}")
    ArrayList<Resource> findByAccess(Long access);
}
