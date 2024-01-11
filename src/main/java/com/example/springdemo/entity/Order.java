package com.example.springdemo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.List;

@TableName("t_order")
public class Order {
    @TableId
    private int orderid;
    private String ordertime;
    private String ordercost;
    @TableField(exist = false)
    private User user;


    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public String getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(String ordertime) {
        this.ordertime = ordertime;
    }

    public String getOrdercost() {
        return ordercost;
    }

    public void setOrdercost(String ordercost) {
        this.ordercost = ordercost;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderid=" + orderid +
                ", ordertime='" + ordertime + '\'' +
                ", ordercost='" + ordercost + '\'' +
                ", user=" + user +
                '}';
    }
}
