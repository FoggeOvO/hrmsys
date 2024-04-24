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
    private final DeptService deptService;
    private final UserService userService;

    private LoginController(AuthService authService, DeptService deptService, UserService userService){
        this.authService = authService;
        this.deptService = deptService;
        this.userService = userService;
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

    @GetMapping("getInitDep")
    @TokenRequired
    public Result getInitDept(HttpServletRequest request){
        String token = request.getHeader("token");
        return Result.ok(deptService.getDept(token));
    }

    @GetMapping("getInitUser")
    @TokenRequired
    public Result getInitUser(HttpServletRequest request){
        List<Integer> deps = new ArrayList<>();
        String token = request.getHeader("token");
        JSONArray dept = deptService.getDept(token);
        getDepIds(dept,deps);
        return Result.ok(userService.getUserByDepId(deps));
    }

    public void getDepIds(JSONArray deps, List<Integer> keys) {
        for (int i = 0; i < deps.size(); i++) {
            JSONObject jsonObject = deps.getJSONObject(i);
            Integer key = jsonObject.getInteger("key");
            keys.add(key);
            if (jsonObject.containsKey("children") && !jsonObject.getJSONArray("children").isEmpty()) {
                getDepIds(jsonObject.getJSONArray("children"), keys);
            }
        }
    }

}
