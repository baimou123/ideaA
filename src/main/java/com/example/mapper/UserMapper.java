package com.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.entity.User;

//在mybatisplus中，单表的增删改查，需要继承一个 BaseMapper<实体类名>
//则，该dao/mapper持久层 就有了 增删改查的所有功能！。。。很简洁，且 功能强大。so，，，必须课下去学。
public interface UserMapper extends BaseMapper<User> {


    //多表的需要写抽象方法！！
}
