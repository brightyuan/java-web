package com.boot.demo.dao;

import com.boot.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserDao {

    @Select("select * from user where userName = #{name}")
    User findUserByName(@Param("name") String  name);

    User findUserById(@Param("id") int  id);
}
