package com.peo.interceptor;

import com.peo.annotation.TokenRequired;
import com.peo.util.JwtHelper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class LoginCheckInterceptor implements HandlerInterceptor {

    @Autowired
    JwtHelper jwtHelper;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(!(handler instanceof HandlerMethod handlerMethod)){
            return true;
        }

        TokenRequired tokenRequired = handlerMethod.getMethodAnnotation(TokenRequired.class);
        if(tokenRequired != null){
            String token = request.getHeader("token");
            if(token == null){
                response.sendError(301,"token is null");
                return false;
            }
            boolean expiration = jwtHelper.isExpiration(token);
            if(expiration){
                response.sendError(302,"token is expire");
                return false;
            }
        }

        return true;
    }
}
