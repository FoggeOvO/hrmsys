package com.peo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.peo.mapper.LoginMapper;
import com.peo.pojo.User;
import com.peo.service.AuthService;
import com.peo.util.JwtHelper;
import com.peo.util.Result;
import jakarta.servlet.ServletException;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.function.ServerRequest;
import org.springframework.web.servlet.function.ServerResponse;

import java.io.IOException;
import java.util.List;


@Service
public class AuthBizHandler implements AuthService {

    private final JwtHelper jwtHelper;
    private final LoginMapper loginMapper;

    public AuthBizHandler(JwtHelper jwtHelper, LoginMapper loginMapper) {
        this.jwtHelper = jwtHelper;
        this.loginMapper = loginMapper;
    }

    @Override
    public ServerResponse getToken(ServerRequest request) throws ServletException, IOException {
        User user = request.body(User.class);
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.select(User::getId).eq(User::getUsername, user.getUsername());
        //1.根据传入的username查找DB中是否有相应人员
        User isUser = loginMapper.selectOne(lambdaQueryWrapper);
        String token = jwtHelper.createToken(Long.valueOf(isUser.getId()));
        return ServerResponse.ok().body(Result.ok(token));
    }

    @Override
    public ServerResponse getCurrentUser(ServerRequest request)  {
        String token = request.headers().header("token").get(0);
        Integer userId = jwtHelper.getUserId(token).intValue();
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.select(User::getId, User::getUsername, User::getPassword, User::getType, User::getGender,
                User::getLastname, User::getLevel, User::getWorkcode, User::getPosition, User::getPosition, User::getDepid,
                User::getHiredate, User::getStatus, User::getAccess, User::getDeleted, User::getVersion).eq(User::getId,userId);
        return ServerResponse.ok().body(Result.ok(loginMapper.selectOne(lambdaQueryWrapper)));
    }
}
