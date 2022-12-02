package com.library.user.service;

import com.library.user.clients.ResourceClient;
import com.library.user.mapper.RegisterMapper;
import com.library.user.mapper.UserMapper;
import com.library.user.pojo.Resource;
import com.library.user.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RegisterMapper registerMapper;

    @Autowired
    private ResourceClient resourceClient;

    //用户注册
    public User registerRequest( String name, String password, String avatar)
    {
        int role = 1;
        Long card_id = 0L;
        Timestamp created_time = new Timestamp(System.currentTimeMillis()); ;
        int access = 1;
        Long id =  registerMapper.addUser(name,password,avatar,role,card_id,created_time,access);
        return registerMapper.addHistory(id);

    }

    //获取用户信息
    //查询方式：/user/{id}
    public User queryById(Long id) {
        return userMapper.findById(id);
    }
    //查询方式：/user/card/{card_id}
    public User queryByCardId(Long card_id) {
        return userMapper.findByCardId(card_id);
    }
    /*//借阅记录列表查询
    public ArrayList<Resource> queryResourceById(Long card_id){
        //获取card_id对应的用户id
        Long id = userMapper.findByCardId(card_id).getId();
        //远程调用获取参数
        ArrayList<Resource> resources = resourceClient.findByUserId(id);

    }*/
    //查询可借阅资源
    public ArrayList<Resource> queryResourceAvail(Long userId){
        //查询用户权限
        Long access = userMapper.findById(userId).getAccess();
        //远程调用获取参数
        ArrayList<Resource> resources = resourceClient.findByUserAccess(access);
        return resources;
    }
}