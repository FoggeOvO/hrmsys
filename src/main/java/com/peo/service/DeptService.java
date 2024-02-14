package com.peo.service;

import com.peo.pojo.Dept;
import com.baomidou.mybatisplus.extension.service.IService;
import com.peo.util.Result;

/**
* @author lvlvlove
* @description 针对表【t_dept】的数据库操作Service
* @createDate 2024-01-26 11:13:43
*/
public interface DeptService extends IService<Dept> {

    Result getDept();
}
