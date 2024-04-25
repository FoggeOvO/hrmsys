package com.peo.service;

import com.alibaba.fastjson2.JSONArray;
import com.peo.pojo.Dept;
import com.baomidou.mybatisplus.extension.service.IService;
import com.peo.util.Result;

import java.util.List;

/**
* @author lvlvlove
* @description 针对表【t_dept】的数据库操作Service
* @createDate 2024-01-26 11:13:43
*/
public interface DeptService extends IService<Dept> {

    JSONArray getDept(String token);
    JSONArray getAllDept();

    List<Integer> getDepIds(String token);

}
