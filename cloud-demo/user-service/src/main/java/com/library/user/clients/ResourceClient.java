package com.library.user.clients;

import com.library.user.pojo.Resource;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;

@FeignClient(name="resource-service")
public interface ResourceClient {

    //查询可借阅书籍，注意路径
    @GetMapping("resource/access/{access}")
    ArrayList<Resource> findByUserAccess(@PathVariable("access") Long access);
}
