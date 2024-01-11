package com.example.springdemo.controller;

import com.example.springdemo.entity.Order;
import com.example.springdemo.entity.User;
import com.example.springdemo.mapper.OrderMapper;
import com.example.springdemo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderMapper orderMapper;

    @GetMapping("/order/all")
    public List<Order> queryAllOrder(){
        List<Order> list = orderMapper.selectList(null);
        System.out.println(list);
        return list;
    }

    @GetMapping("/order/alluser")
    public List<Order> queryAllOrderWithUser(){
        List<Order> list = orderMapper.selectAllOrderWithUser();
        System.out.println(list);
        return list;
    }

}
