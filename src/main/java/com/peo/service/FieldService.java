package com.peo.service;

import com.peo.pojo.CustomerField;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
* @author lvlvlove
* @description 针对表【t_filed】的数据库操作Service
* @createDate 2024-01-26 11:13:43
*/
public interface FieldService extends IService<CustomerField> {
    List<Map<String,Object>> getAllField(List<Integer> userIds, List<String> columns);
}
