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
    public Result getUser() {
        List<UserVo> user = userMapper.getUser();
        return Result.ok(user);
    }

    @Override
    public Result getUserByDepId(List<Integer> depId) {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.in(User::getDepid, depId);
        List<User> users = userMapper.selectList(lambdaQueryWrapper);
        return Result.ok(users);
    }

    @Override
    public Result getUserById(Integer  id) {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(User::getId,  id);
        User user = userMapper.selectOne(lambdaQueryWrapper);
        return Result.ok(user);
    }

    @Override
    public Result updateUserById(User user) {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(User::getId, user.getId());
        int update = userMapper.update(user, lambdaQueryWrapper);
        if (update == 0) {
            return Result.failure(ResultCodeEnum.NOTCHANGE);
        }
        return Result.ok(update);
    }

    @Override
    public Result createUser(User user) {
        int insert = userMapper.insert(user);
        if (insert == 0) {
            return Result.failure(ResultCodeEnum.NOTCHANGE);
        }
        return Result.ok(insert);
    }

    @Override
    public Result deleteUser(User user) {
        int del = userMapper.deleteById(user);
        if (del == 0) {
            return Result.failure(ResultCodeEnum.NOTCHANGE);
        }
        return Result.ok(del);
    }

}




