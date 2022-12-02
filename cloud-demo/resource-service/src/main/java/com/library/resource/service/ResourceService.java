package com.library.resource.service;

import com.library.resource.mapper.ResourceMapper;
import com.library.resource.pojo.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ResourceService {

    @Autowired
    private ResourceMapper resourceMapper;

    public Resource queryResourceById(Long resourceId) {
        // 根据id查询资源
        Resource resource = resourceMapper.findById(resourceId);
        // 返回
        return resource;
    }

    public ArrayList<Resource> queryResourceByAccess(Long access) {
        // 根据access查询资源
        ArrayList<Resource> resource = resourceMapper.findByAccess(access);
        // 返回
        return resource;
    }
}
