package com.peo.service.impl;


import com.alibaba.fastjson2.JSONArray;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.peo.constants.FieldType;
import com.peo.mapper.ColumnMapper;
import com.peo.mapper.FieldMapper;
import com.peo.mapper.HrmSelectItemMapper;
import com.peo.pojo.*;
import com.peo.service.DeptService;
import com.peo.service.UserService;
import com.peo.mapper.UserMapper;
import com.peo.util.JSONUtil;
import com.peo.vo.FieldVo;
import com.peo.vo.UserVo;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
    private final HrmSelectItemMapper hrmSelectItemMapper;

    private static final int CHECKBOX = 1;
    private static final int DROPBOX = 2;


    public UserServiceImpl(UserMapper userMapper, DeptService deptService, FieldMapper fieldMapper, ColumnMapper columnMapper, HrmSelectItemMapper hrmSelectItemMapper) {
        this.userMapper = userMapper;
        this.deptService = deptService;
        this.fieldMapper = fieldMapper;
        this.columnMapper = columnMapper;
        this.hrmSelectItemMapper = hrmSelectItemMapper;
    }

    @Override
    public List<User> getUser(String token) {
        JSONArray dept = deptService.getDept(token);
        List<Integer> depIds = new ArrayList<>();
        JSONUtil.getDepIds(dept, depIds);
        return getUserByDepId(depIds, 1);
    }

    @Override
    public Integer getUserCount(List<Integer> depId) {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.select(User::getId).in(User::getDepid, depId);
        return Math.toIntExact(userMapper.selectCount(lambdaQueryWrapper));
    }

    @Override
    public List<User> getUserByDepId(List<Integer> depId, Integer current) {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        Page<User> page = new Page<>(current, 10);
        lambdaQueryWrapper.select(User::getId, User::getUsername, User::getDepid, User::getWorkcode, User::getLastname, User::getGender, User::getType, User::getHiredate, User::getLevel, User::getAccess, User::getPosition, User::getStatus).in(User::getDepid, depId);
        userMapper.selectPage(page, lambdaQueryWrapper);

        List<User> records = page.getRecords();
        List<Integer> userIds = new ArrayList<>();
        for (User user : records) {
            userIds.add(user.getId());
        }

        //这里可以用Mybatis Plus获取到t_sys_field登记得自定义字段信息
        LambdaQueryWrapper<Column> columnLambdaQueryWrapper = new LambdaQueryWrapper<>();
        columnLambdaQueryWrapper.select(Column::getId, Column::getFieldValue, Column::getFieldName, Column::getFieldType, Column::getFieldWidth, Column::getSelectId).eq(Column::getDeleted, "0");
        List<Column> columns = columnMapper.selectList(columnLambdaQueryWrapper);


        List<String> cols = new ArrayList<>();
        for (Column column : columns) {
            cols.add(column.getFieldValue());
        }


/*

        这里不能直接用Mybatis Plus获得静态结果,因为自定义列是随时可能会新增得. 无法使用一个固定得POJO来存储,所以采用了List<Map<String, Object>>来进行结果获取
        获取得结果为: [
            {
                 "user_id" : "1",
                 "field1" : "xx",
                 "field2" : "xx",
                 "field3" : "xx",
                 ......
                "fieldXX" : "xx"
            },
            {
              {
                 "user_id" : "2",
                 "field1" : "xx",
                 "field2" : "xx",
                 "field3" : "xx",
                 ......
                "fieldXX" : "xx"
            }
            }
        ]

 */
        List<Map<String, Object>> allFieldByUserId = fieldMapper.getAllFieldByUserId(userIds, cols);


        for (Map<String, Object> field : allFieldByUserId) {
            UserField userField = getFieldShowName(field, columns);
            for (User user : records) {
                if (Objects.equals(userField.getUserId(), user.getId())) {
                    user.setUserField(userField);
                }
            }
        }

        return records;
    }

    @Override
    public List<User> getUserByAccess(Integer access) {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.select(User::getId, User::getUsername, User::getDepid, User::getWorkcode, User::getLastname, User::getGender, User::getType, User::getHiredate, User::getLevel, User::getAccess, User::getPosition, User::getStatus, User::getDeleted).eq(User::getAccess, access);
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


    private UserField getFieldShowName(Map<String, Object> field, List<Column> columns) {
        String userId = String.valueOf(field.get("user_id"));
        if (userId == null) {
            throw new IllegalArgumentException("user_id is missing from the field map");
        }
        UserField userField = new UserField(Integer.parseInt(userId));
        List<FieldVo> fieldVos = new ArrayList<>();

        for (Map.Entry<String, Object> entry : field.entrySet()) {
            for (Column column : columns) {
                if (Objects.equals(entry.getKey(), column.getFieldValue())) {
                    FieldVo fieldVo = new FieldVo();
                    Integer fieldType = column.getFieldType();
                    Integer selectId = column.getSelectId();
                    String realValue = String.valueOf(entry.getValue());
                    fieldVo.setFieldName(column.getFieldName());
                    fieldVo.setFieldValue(realValue);
                    fieldVo.setFieldType(String.valueOf(fieldType));

                    switch (fieldType) {
                        case CHECKBOX:
                            boolean enable = Objects.equals(String.valueOf(realValue), "1");
                            fieldVo.setFieldShow(Boolean.toString(enable));
                            break;
                        case DROPBOX:
                            //方法getFieldValue,传入selectId和FieldValue.返回得到的选项作为字段显示值
                            HrmSelectItem hrmSelectItem = getFieldShow(realValue, selectId);
                            fieldVo.setFieldShow(hrmSelectItem.getSelectName());
                            break;
                        default:
                            //字段显示值=字段原值
                            fieldVo.setFieldShow(String.valueOf(realValue));
                            break;
                    }
                    fieldVos.add(fieldVo);
                }
            }
        }
        userField.setFields(fieldVos);
        return userField;

    }

    private HrmSelectItem getFieldShow(Object filedValue, Integer selectId) {
        //TODO 这里返回的结果可能会为空,造成NullPointException
        LambdaQueryWrapper<HrmSelectItem> hrmSelectItemLambdaQueryWrapper = new LambdaQueryWrapper<>();
        hrmSelectItemLambdaQueryWrapper.select(HrmSelectItem::getId, HrmSelectItem::getSelectValue, HrmSelectItem::getSelectName, HrmSelectItem::getMainid)
                .eq(HrmSelectItem::getMainid, selectId)
                .eq(HrmSelectItem::getSelectValue, filedValue);
        return hrmSelectItemMapper.selectOne(hrmSelectItemLambdaQueryWrapper);
    }

}




