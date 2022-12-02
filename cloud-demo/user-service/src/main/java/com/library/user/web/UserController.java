package com.library.user.web;

import com.library.user.pojo.Resource;
import com.library.user.pojo.User;
import com.library.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 路径： /user/110
     *
     * @param id 用户id
     * @return 用户
     */
    @GetMapping("{id}")
    public User queryUserById(@PathVariable("id") Long id) {
        return userService.queryById(id);
    }

    /**
     * 路径：/register
     * @param name 用户名
     * @param password 密码
     * @param avatar 用户头像
     * @return 注册成功的用户信息
     * */
    @RequestMapping(value = "/register/{name}/{password}/{avatar}",
            method = {RequestMethod.GET, RequestMethod.POST})
    public User registerUser(@PathVariable("name") String name,
                             @PathVariable("password") String password,
                             @PathVariable("avatar") String avatar){
        return userService.registerRequest(name, password , avatar);
    }

    @GetMapping("/user-avail/{id}")
    public ArrayList<Resource> queryResourceByAccess(@PathVariable("id") Long userId){
        return userService.queryResourceAvail(userId);
    }

}
