package com.example.springdemo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springdemo.entity.User;
import com.example.springdemo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/user")
    public List<User> queryUser(){
        List<User> list = userMapper.selectList(null);
        System.out.println(list);
        return list;
    }

    @PostMapping("/user")
    public String saveUser(User user){
            int i = userMapper.insert(user);
            if(i > 0){
                return "插入成功";
            }else {
                return "插入失败";
            }
    }

    @GetMapping("/userorder")
    public List<User> queryUserWithOrder(){
        List<User> list = userMapper.selectAllUserWithOrder();
        System.out.println(list);
        return list;
    }

    @GetMapping("/user/{id}")
    public String getUserInfoById(@PathVariable int id){
        System.out.println(id);
        return "getUserInfoById";
    }

    @GetMapping("/user/find")
    public List<User> findByCondition(String username) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        return userMapper.selectList(queryWrapper);
    }

    @GetMapping("/user/findByPage")
    public IPage findByPage(){
        Page<User> page = new Page<>(0,2);
        IPage iPage = userMapper.selectPage(page,null);
        return iPage;
    }

}
