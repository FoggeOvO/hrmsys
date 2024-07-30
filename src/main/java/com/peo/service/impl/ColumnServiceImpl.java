package com.peo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.peo.pojo.Column;
import com.peo.service.ColumnService;
import com.peo.mapper.ColumnMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author lvlvlove
* @description 针对表【t_column】的数据库操作Service实现
* @createDate 2024-01-26 11:13:43
*/
@Service
public class ColumnServiceImpl extends ServiceImpl<ColumnMapper, Column>
    implements ColumnService {

    private final ColumnMapper columnMapper;
    public ColumnServiceImpl(ColumnMapper columnMapper){
        this.columnMapper = columnMapper;
    }
    @Override
    public List<Column> getAllColumns() {
        LambdaQueryWrapper<Column> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.select(Column::getId,Column::getFieldName,Column::getFieldValue,Column::getFieldType,Column::getFieldWidth,Column::getSelectId);
        return columnMapper.selectList(lambdaQueryWrapper);
    }
}




