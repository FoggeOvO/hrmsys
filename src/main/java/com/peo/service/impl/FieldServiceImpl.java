package com.peo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.peo.pojo.Field;
import com.peo.pojo.User;
import com.peo.service.FieldService;
import com.peo.mapper.FieldMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author lvlvlove
* @description 针对表【t_filed】的数据库操作Service实现
* @createDate 2024-01-26 11:13:43
*/
@Service
public class FieldServiceImpl extends ServiceImpl<FieldMapper, Field>
    implements FieldService {

    private final FieldMapper fieldMapper;

    public FieldServiceImpl(FieldMapper fieldMapper){
        this.fieldMapper = fieldMapper;
    }

    @Override
    public List<Field> getAllField(List<Integer> userIds) {
        LambdaQueryWrapper<Field> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.select(Field::getId, Field::getMeal, Field::getHouse, Field::getAnnul, Field::getTech, Field::getUserId ).in(Field::getUserId, userIds);
        return fieldMapper.selectList(lambdaQueryWrapper);
    }
}




