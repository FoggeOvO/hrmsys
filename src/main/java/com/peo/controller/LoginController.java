package com.peo.controller;


import com.peo.mapper.LoginMapper;
import com.peo.pojo.User;
import com.peo.service.AuthService;
import com.peo.service.UserService;
import com.peo.util.Result;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth")
public class LoginController {

    @Autowired
    AuthService authService;

    @PostMapping("getToken")
    public Result getToken(@RequestBody User user){
       return authService.getToken(user);
    }

    @GetMapping ("getCurrentUser")
    public Result getCurrentUser(HttpServletRequest request){
        String token = request.getHeader("token");
        return authService.getCurrentUser(token);
    }

}
