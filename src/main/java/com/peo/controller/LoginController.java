package com.peo.controller;


import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.peo.annotation.TokenRequired;
import com.peo.mapper.LoginMapper;
import com.peo.pojo.User;
import com.peo.service.AuthService;
import com.peo.service.DeptService;
import com.peo.service.UserService;
import com.peo.util.Result;
import com.peo.util.ResultCodeEnum;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("auth")
public class LoginController {

//    private final AuthService authService;
//
//    public LoginController(AuthService authService){
//        this.authService = authService;
//    }

//    @PostMapping("getToken")
//    public Result getToken(@RequestBody User user){
//        String token = authService.getToken(user);
//        return Result.ok(token);
//    }

//    @GetMapping ("getCurrentUser")
//    @TokenRequired
//    public Result getCurrentUser(HttpServletRequest request){
//        String token = request.getHeader("token");
//        User currentUser = authService.getCurrentUser(token);
//        if(currentUser == null){
//            return Result.failure(ResultCodeEnum.NODATA);
//        }
//        return Result.ok(currentUser);
//
//    }


}
