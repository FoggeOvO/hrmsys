package com.peo.service.impl;


import com.alibaba.fastjson2.JSONArray;
import com.baomidou.mybatisplus.annotation.InterceptorIgnore;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.peo.annotation.DeptAuth;
import com.peo.mapper.ColumnMapper;
import com.peo.mapper.FieldMapper;
import com.peo.mapper.LoginMapper;
import com.peo.pojo.Column;
import com.peo.pojo.Field;
import com.peo.pojo.User;
import com.peo.service.DeptService;
import com.peo.service.UserService;
import com.peo.mapper.UserMapper;
import com.peo.util.JSONUtil;
import com.peo.util.JwtHelper;
import com.peo.util.Result;
import com.peo.util.ResultCodeEnum;
import com.peo.vo.FieldVo;
import com.peo.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


/**
 * @author lvlvlove
 * @description 针对表【t_user】的数据库操作Service实现
 * @createDate 2024-01-26 11:13:43
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    private final UserMapper userMapper;
    private final DeptService deptService;
    private final FieldMapper fieldMapper;

    private final ColumnMapper columnMapper;

    public UserServiceImpl(UserMapper userMapper, DeptService deptService, FieldMapper fieldMapper, ColumnMapper columnMapper){
        this.userMapper = userMapper;
        this.deptService = deptService;
        this.fieldMapper = fieldMapper;
        this.columnMapper = columnMapper;
    }

    @Override
    public List<UserVo> getUser(String token) {
        JSONArray dept = deptService.getDept(token);
        List<Integer> depIds = new ArrayList<>();
        JSONUtil.getDepIds(dept,depIds);
        return getUserByDepId(depIds,1);
    }

    @Override
    public Integer getUserCount(List<Integer> depId) {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.select(User::getId).in(User::getDepid, depId);
        return Math.toIntExact(userMapper.selectCount(lambdaQueryWrapper));
    }

    @Override
    public List<UserVo> getUserByDepId(List<Integer> depId, Integer current) {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        Page<User> page = new Page<>(current,10);
        lambdaQueryWrapper.select(User::getId, User::getUsername, User::getDepid, User::getWorkcode, User::getLastname, User::getGender, User::getType, User::getHiredate, User::getLevel, User::getAccess, User::getPosition, User::getStatus ).in(User::getDepid, depId);
        userMapper.selectPage(page,lambdaQueryWrapper);

        List<User> records = page.getRecords();
        List<Integer> userIds = new ArrayList<>();
        for(User user : records) {
            userIds.add(user.getId());
        }

        LambdaQueryWrapper<Field> fieldLambdaQueryWrapper = new LambdaQueryWrapper<>();
        fieldLambdaQueryWrapper.select().in(Field::getUserId,userIds);
        List<Field> fields = fieldMapper.selectList(fieldLambdaQueryWrapper);
        List<UserVo> userVos = new ArrayList<>();

        LambdaQueryWrapper<Column> columnLambdaQueryWrapper = new LambdaQueryWrapper<>();
        columnLambdaQueryWrapper.select(Column::getId, Column::getFieldValue, Column::getFieldName, Column::getFieldType, Column::getFieldWidth, Column::getSelectId).eq(Column::getDeleted,"0");
        List<Column> columns = columnMapper.selectList(columnLambdaQueryWrapper);
        for(Field field : fields){
            FieldVo fieldVo = new FieldVo();
            for(Column column : columns){
                fieldVo.setFieldName(column.getFieldName());

            }
        }
        return null;
//        return userMapper.getUserByDepIds(depId, current);
    }

    @Override
    public List<User> getUserByAccess(Integer access) {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.select(User::getId, User::getUsername, User::getDepid, User::getWorkcode, User::getLastname, User::getGender, User::getType, User::getHiredate, User::getLevel, User::getAccess, User::getPosition, User::getStatus, User::getDeleted ).eq(User::getAccess, access);
        return userMapper.selectList(lambdaQueryWrapper);
    }

    @Override
    public User getUserById(Integer id) {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(User::getId, id);
        return userMapper.selectOne(lambdaQueryWrapper);
    }

    @Override
    public Integer updateUserById(User user) {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(User::getId, user.getId());
        return userMapper.update(user, lambdaQueryWrapper);
    }

    @Override
    public Integer createUser(User user) {
        return userMapper.insert(user);
    }

    @Override
    public Integer deleteUser(User user) {
        return userMapper.deleteById(user);
    }


}




