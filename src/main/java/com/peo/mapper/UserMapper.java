package com.peo.mapper;

import com.baomidou.mybatisplus.annotation.InterceptorIgnore;
import com.peo.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.peo.vo.UserVo;

import java.util.List;

/**
* @author lvlvlove
* @description 针对表【t_user】的数据库操作Mapper
* @createDate 2024-01-26 11:13:43
* @Entity com.peo.pojo.User
*/

public interface UserMapper extends BaseMapper<User> {
    List<UserVo> getUser();
}




