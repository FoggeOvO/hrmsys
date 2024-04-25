package com.peo.service;

import com.peo.pojo.User;
import com.baomidou.mybatisplus.extension.service.IService;


import java.util.List;

/**
* @author lvlvlove
* @description 针对表【t_user】的数据库操作Service
* @createDate 2024-01-26 11:13:43
*/
public interface UserService extends IService<User> {

    List<User> getUser(String token);

    Integer getUserCount(List<Integer> depId);

    List<User> getUserByDepId(List<Integer> depId, Integer current);

    User getUserById(Integer id);

    Integer updateUserById(User user);

    Integer createUser(User user);

    Integer deleteUser(User user);

}
