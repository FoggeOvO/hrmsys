package com.peo.service;

import com.peo.pojo.User;
import com.peo.util.JwtHelper;
import com.peo.util.Result;
import org.springframework.beans.factory.annotation.Autowired;

public interface AuthService {
    Result getToken(User user);
    Result getCurrentUser(String token);
}
