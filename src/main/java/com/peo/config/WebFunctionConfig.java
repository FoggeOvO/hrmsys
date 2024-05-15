package com.peo.config;


import com.peo.service.impl.AuthBizHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.function.*;

@Configuration
public class WebFunctionConfig {
    @Bean
    public RouterFunction<ServerResponse> loginRoute(AuthBizHandler authBizHandler){
        return RouterFunctions.route()
                .POST("/auth/getToken", RequestPredicates.accept(MediaType.APPLICATION_JSON),authBizHandler::getToken)
                .GET("/auth/getCurrentUser", authBizHandler::getCurrentUser)
                .build();
    }
}
