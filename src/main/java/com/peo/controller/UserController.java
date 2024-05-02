package com.peo.controller;

import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.peo.annotation.TokenRequired;
import com.peo.pojo.User;
import com.peo.service.AuthService;
import com.peo.service.DeptService;
import com.peo.service.UserService;

import com.peo.util.Result;
import com.peo.vo.UserVo;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping ("getUser")
    @TokenRequired
    public Result getUser(HttpServletRequest request) {
        String token = request.getHeader("token");
        List<User> users = userService.getUser(token);
        return Result.ok(users);
    }

    @GetMapping("getUserByDepId")
    @TokenRequired
    public Result getUserByDepId(@RequestParam List<Integer> depId, Integer current) {
        List<User> user = userService.getUserByDepId(depId, current);
        return Result.ok(user);
    }

    @GetMapping("getUserCount")
    @TokenRequired
    public Result getUserCount(@RequestParam List<Integer> depId) {
        Integer count = userService.getUserCount(depId);
        return Result.ok(count);
    }

    @GetMapping("getUserById/{ids}")
    @TokenRequired
    public Result getUserById(@PathVariable Integer ids) {
        User user = userService.getUserById(ids);
        return Result.ok(user);
    }

    @GetMapping("getUserByAccess/{access}")
    @TokenRequired
    public Result getUserByAccess(@PathVariable Integer access) {
        List<User> users = userService.getUserByAccess(access);
        return Result.ok(users);
    }

    @PutMapping("updateUserById")
    @TokenRequired
    public Result updateUserById(@RequestBody User user) {
        Integer i = userService.updateUserById(user);
        return Result.ok(i);
    }

    @PostMapping("createUser")
    @TokenRequired
    public Result createUser(@RequestBody User user) {
        Integer i = userService.createUser(user);
        return Result.ok(i);
    }

    @DeleteMapping("deleteUser")
    @TokenRequired
    public Result deleteUser(@RequestBody User user) {
        Integer i = userService.deleteUser(user);
        return Result.ok(i);
    }



}
