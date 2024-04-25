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
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("auth")
public class LoginController {

    private final AuthService authService;

    public LoginController(AuthService authService){
        this.authService = authService;
    }

    @PostMapping("getToken")
    public Result getToken(@RequestBody User user){
       return authService.getToken(user);
    }

    @GetMapping ("getCurrentUser")
    @TokenRequired
    public Result getCurrentUser(HttpServletRequest request){
        String token = request.getHeader("token");
        return authService.getCurrentUser(token);
    }


}
