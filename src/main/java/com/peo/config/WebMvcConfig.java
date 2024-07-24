package com.peo.config;

import com.peo.interceptor.LoginCheckInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    LoginCheckInterceptor loginCheckInterceptor;

    public WebMvcConfig (LoginCheckInterceptor loginCheckInterceptor){
        this.loginCheckInterceptor = loginCheckInterceptor;
    }
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginCheckInterceptor).excludePathPatterns("/login/*");
    }
}
