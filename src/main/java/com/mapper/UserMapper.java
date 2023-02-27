package com.mapper;

import com.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    //查询
    public List<User> queryAll();
}
