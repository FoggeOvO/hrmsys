package com.peo.service.impl;


import com.baomidou.mybatisplus.annotation.InterceptorIgnore;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.peo.annotation.DeptAuth;
import com.peo.mapper.LoginMapper;
import com.peo.pojo.User;
import com.peo.service.UserService;
import com.peo.mapper.UserMapper;
import com.peo.util.JwtHelper;
import com.peo.util.Result;
import com.peo.util.ResultCodeEnum;
import com.peo.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;


/**
 * @author lvlvlove
 * @description 针对表【t_user】的数据库操作Service实现
 * @createDate 2024-01-26 11:13:43
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    UserMapper userMapper;


    @Override
    public List<UserVo> getUser(List<Integer> depIds) {
        return userMapper.getUser(depIds);
    }

    @Override
    public List<User> getUserByDepId(List<Integer> depId) {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.in(User::getDepid, depId);
        return userMapper.selectList(lambdaQueryWrapper);
    }

    @Override
    public User getUserById(Integer id) {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(User::getId, id);
        return userMapper.selectOne(lambdaQueryWrapper);
    }

    @Override
    public Integer updateUserById(User user) {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(User::getId, user.getId());
        return userMapper.update(user, lambdaQueryWrapper);
    }

    @Override
    public Integer createUser(User user) {
        return userMapper.insert(user);
    }

    @Override
    public Integer deleteUser(User user) {
        return userMapper.deleteById(user);
    }


}




