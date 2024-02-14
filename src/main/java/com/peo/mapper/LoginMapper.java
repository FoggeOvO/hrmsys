package com.peo.mapper;

import com.baomidou.mybatisplus.annotation.InterceptorIgnore;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.peo.pojo.User;

@InterceptorIgnore(dataPermission = "true")
public interface LoginMapper extends BaseMapper<User> {
}
