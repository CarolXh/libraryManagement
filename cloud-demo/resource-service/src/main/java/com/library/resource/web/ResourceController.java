package com.library.resource.web;

import com.library.resource.pojo.Resource;
import com.library.resource.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("resource")
public class ResourceController {

   @Autowired
   private ResourceService resourceService;

    @GetMapping("{resourceId}")
    public Resource queryResourceById(@PathVariable("resourceId") Long resourceId) {
        // 根据id查询资源并返回
        return resourceService.queryResourceById(resourceId);
    }

    @GetMapping("/access/{access}")
    public ArrayList<Resource> queryResourceByAccess(@PathVariable("access") Long access) {
        // 根据access查询资源并返回
        return resourceService.queryResourceByAccess(access);
    }

}
