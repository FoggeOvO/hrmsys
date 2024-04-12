package com.peo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.peo.mapper.ColumnMapper;
import com.peo.mapper.LoginMapper;
import com.peo.pojo.Column;
import com.peo.pojo.User;
import com.peo.service.AuthService;
import com.peo.util.JwtHelper;
import com.peo.util.Result;
import com.peo.util.ResultCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AuthServiceImpl  extends ServiceImpl<ColumnMapper, Column>
        implements AuthService {

    @Autowired
    JwtHelper jwtHelper;
    @Autowired
    LoginMapper loginMapper;

    @Override
    public Result getToken(User user) {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(User::getUsername, user.getUsername());

        //1.根据传入的username查找DB中是否有相应人员
        User isUser = loginMapper.selectOne(lambdaQueryWrapper);
        if (isUser == null) {
            return Result.failure(ResultCodeEnum.USERNAME_ERROR);
        }
        if (!Objects.equals(isUser.getPassword(), user.getPassword())) {
            return Result.failure(ResultCodeEnum.PASSWORD_ERROR);
        }

        String token = jwtHelper.createToken(Long.valueOf(isUser.getId()));

        return Result.ok(token);
    }

    @Override
    public Result getCurrentUser(String token) {

        Integer userId = jwtHelper.getUserId(token).intValue();
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(User::getId,userId);

        User currentUser = loginMapper.selectOne(lambdaQueryWrapper);
        if(currentUser == null){
            return Result.failure(ResultCodeEnum.NODATA);
        }
        return Result.ok(currentUser);
    }


}
