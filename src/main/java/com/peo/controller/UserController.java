package com.peo.controller;

import com.peo.annotation.TokenRequired;
import com.peo.pojo.User;
import com.peo.service.UserService;

import com.peo.util.Result;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("getUser")
    @TokenRequired
    public Result getUser(){
        return userService.getUser();
    }

    @GetMapping("getUserByDepId")
    @TokenRequired
    public Result getUserByDepId(@RequestParam List<Integer> depId){
        System.out.println(depId);
        return userService.getUserByDepId(depId);
    }

    @GetMapping("getUserById/{ids}")
    @TokenRequired
    public Result getUserById(@PathVariable Integer ids){
        return userService.getUserById(ids);
    }

    @PutMapping("updateUserById")
    @TokenRequired
    public Result updateUserById(@RequestBody User user){
        return userService.updateUserById(user);
    }

    @PostMapping("createUser")
    @TokenRequired
    public Result createUser(@RequestBody User user){
        return userService.createUser(user);
    }


    @DeleteMapping("deleteUser")
    @TokenRequired
    public Result deleteUser(@RequestBody User user){
        return userService.deleteUser(user);
    }
}
