package com.peo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.peo.pojo.Dept;
import com.peo.service.DeptService;
import com.peo.mapper.DeptMapper;
import com.peo.util.JwtHelper;
import com.peo.util.Result;
import com.peo.util.ResultCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author lvlvlove
* @description 针对表【t_dept】的数据库操作Service实现
* @createDate 2024-01-26 11:13:43
*/
@Service
public class DeptServiceImpl extends ServiceImpl<DeptMapper, Dept> implements DeptService {
    @Autowired
    JwtHelper jwtHelper;
    @Autowired
    DeptMapper deptMapper;

    @Override
    public Result getDept() {
        LambdaQueryWrapper<Dept> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.select(Dept::getDepname,Dept::getParent,Dept::getId).eq(Dept::getDeleted,0);;
        List<Dept> depts = deptMapper.selectList(lambdaQueryWrapper);
        if(depts == null){
            return Result.failure(ResultCodeEnum.NODATA);
        }
        return Result.ok(depts);
    }
}




