package com.example.springdemo.mapper;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springdemo.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {

//    @Select("select * from user")
//    public List<User> getAllUser();
//
//    @Select("select * from user where userid=#{userid}")
//    public int findByUserid(int userid);
//
//    @Select("select * from user where username=#{username}")
//    public int findByUsername(String username);
//
//    @Select("select * from user where birthday=#{birthday}")
//    public int findByBirthday(String birthday);
//
//    @Insert("insert into user values (#{userid},#{username},#{password},#{birthday})")
//    public int addUser(User user);
//
//    @Insert("update user set username=#{username}, password=#{password}, birthday=#{birthday} where userid=#{userid}")
//    public int updateUser(User user);

    @Select("select * from user where userid = #{userid}")
    User selectByUserId(int userid);

    @Select("select * from user")
    @Results(
            {
                    @Result(column = "userid", property = "userid"),
                    @Result(column = "username", property = "username"),
                    @Result(column = "password", property = "password"),
                    @Result(column = "birthday", property = "birthday"),
                    @Result(column = "userid", property = "orders", javaType = List.class,
                            many = @Many(select = "com.example.springdemo.mapper.OrderMapper.selectByUserid"))
            }
    )
    public List<User> selectAllUserWithOrder();
}
