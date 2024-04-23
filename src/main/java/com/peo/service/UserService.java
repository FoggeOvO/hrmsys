package com.peo.service;

import com.peo.pojo.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.peo.util.Result;
import com.peo.vo.UserVo;

import java.util.List;

/**
* @author lvlvlove
* @description 针对表【t_user】的数据库操作Service
* @createDate 2024-01-26 11:13:43
*/
public interface UserService extends IService<User> {

    List<UserVo> getUser(List<Integer> depIds);

    List<User> getUserByDepId(List<Integer> depId);

    User getUserById(Integer id);

    Integer updateUserById(User user);

    Integer createUser(User user);

    Integer deleteUser(User user);

}
