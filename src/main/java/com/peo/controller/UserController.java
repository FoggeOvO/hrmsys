package com.peo.controller;

import com.peo.annotation.TokenRequired;
import com.peo.pojo.CustomerField;
import com.peo.pojo.User;
import com.peo.service.FieldService;
import com.peo.service.UserService;

import com.peo.util.Result;
import com.peo.vo.UserVo;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {
    UserService userService;
    FieldService fieldService;

    public UserController(UserService userService, FieldService fieldService) {
        this.userService = userService;
        this.fieldService = fieldService;
    }

    @GetMapping ("getUser")
    @TokenRequired
    public Result getUser(HttpServletRequest request) {
        String token = request.getHeader("token");
        List<UserVo> users = userService.getUser(token);
        return Result.ok(users);
    }

    @GetMapping("getUserByDepId")
    @TokenRequired
    public Result getUserByDepId(@RequestParam List<Integer> depId, Integer current) {
        List<UserVo> user = userService.getUserByDepId(depId, current);
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

    @GetMapping("getFieldsByUserId")
    @TokenRequired
    public Result getFieldsByUserId(@RequestParam List<Integer> ids) {
        List<CustomerField> allField = fieldService.getAllField(ids);
        return Result.ok(allField);
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
