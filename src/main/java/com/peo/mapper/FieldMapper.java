package com.peo.mapper;

import com.peo.pojo.CustomerField;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.MapKey;

import java.util.List;
import java.util.Map;

/**
* @author lvlvlove
* @description 针对表【t_filed】的数据库操作Mapper
* @createDate 2024-01-26 11:13:43
* @Entity com.peo.pojo.Filed
*/
public interface FieldMapper extends BaseMapper<CustomerField> {

    @MapKey("")
    List<Map<String, Object>> getAllFieldByUserId(List<Integer> userIds, List<String> columns);
}




