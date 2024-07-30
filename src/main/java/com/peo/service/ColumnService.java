package com.peo.service;

import com.peo.pojo.Column;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author lvlvlove
* @description 针对表【t_column】的数据库操作Service
* @createDate 2024-01-26 11:13:43
*/
public interface ColumnService extends IService<Column> {
    List<Column> getAllColumns();
}
