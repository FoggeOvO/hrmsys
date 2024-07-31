package com.peo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.peo.pojo.CustomerField;
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
public class FieldServiceImpl extends ServiceImpl<FieldMapper, CustomerField>
    implements FieldService {

    private final FieldMapper fieldMapper;

    public FieldServiceImpl(FieldMapper fieldMapper){
        this.fieldMapper = fieldMapper;
    }

    @Override
    public List<CustomerField> getAllField(List<Integer> userIds) {
        LambdaQueryWrapper<CustomerField> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.select(CustomerField::getId, CustomerField::getField1, CustomerField::getField2, CustomerField::getField3, CustomerField::getField4, CustomerField::getUserId ).in(CustomerField::getUserId, userIds);
        return fieldMapper.selectList(lambdaQueryWrapper);
    }
}




