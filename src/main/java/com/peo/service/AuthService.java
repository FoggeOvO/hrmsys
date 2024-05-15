package com.peo.service;

import com.peo.pojo.User;
import com.peo.util.JwtHelper;
import com.peo.util.Result;
import jakarta.servlet.ServletException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.function.ServerRequest;
import org.springframework.web.servlet.function.ServerResponse;

import java.io.IOException;

public interface AuthService {
    ServerResponse getToken(ServerRequest request) throws ServletException, IOException;
    ServerResponse getCurrentUser(ServerRequest request) throws ServletException, IOException;
}
