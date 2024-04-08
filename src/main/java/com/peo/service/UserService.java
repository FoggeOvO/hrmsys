package com.peo.service;

import com.peo.pojo.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.peo.util.Result;

import java.util.List;

/**
* @author lvlvlove
* @description 针对表【t_user】的数据库操作Service
* @createDate 2024-01-26 11:13:43
*/
public interface UserService extends IService<User> {

    Result login(User user);

    Result getUser();

    Result getUserByDepId(List<Integer> depId);

    Result getUserById(Integer id);

    Result updateUserById(User user);

    Result createUser(User user);

    Result deleteUser(User user);
}
