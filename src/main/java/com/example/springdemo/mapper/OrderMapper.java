package com.example.springdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springdemo.entity.Order;
import com.example.springdemo.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface OrderMapper extends BaseMapper<Order> {

    @Select("select * from t_order where userid = #{userid}")
    List<Order> selectByUserid();

    @Select("select * from t_order")
    @Results(
            {
                    @Result(column = "orderid", property = "orderid"),
                    @Result(column = "ordertime", property = "ordertime"),
                    @Result(column = "ordercost", property = "ordercost"),
                    @Result(column = "userid", property = "user", javaType = User.class,
                            one = @One(select = "com.example.springdemo.mapper.UserMapper.selectByUserId"))
            }
    )
    public List<Order> selectAllOrderWithUser();
}
