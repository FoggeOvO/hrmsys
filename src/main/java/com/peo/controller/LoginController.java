package com.peo.controller;


import com.peo.pojo.User;
import com.peo.service.UserService;
import com.peo.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class LoginController {
    @Autowired
    UserService userService;

    @PostMapping("getToken")
    public Result login(@RequestBody User user){
       return userService.login(user);
    }

}
