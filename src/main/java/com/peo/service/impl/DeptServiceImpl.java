package com.peo.service.impl;

import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.peo.pojo.Dept;
import com.peo.service.DeptService;
import com.peo.mapper.DeptMapper;
import com.peo.util.JwtHelper;
import com.peo.util.Result;
import com.peo.util.ResultCodeEnum;
import com.peo.vo.DeptVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


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
        List<Dept> deps = deptMapper.selectList(lambdaQueryWrapper);
        DeptVo root = buildDeptTree(deps);
        if(root == null){
            return Result.failure(ResultCodeEnum.NODATA);
        }
        return Result.ok(root.toString());
    }

    public DeptVo buildDeptTree(List<Dept> deps) {
        Map<Integer, DeptVo> voMap = new HashMap<>();
        DeptVo root = null;

        // 首先将所有 Dept 转换为 DeptVo 并存储到 Map 中以便快速查找
        for (Dept dept : deps) {
            voMap.put(dept.getId(), new DeptVo(dept.getId(), dept.getDepname()));
        }
        // 遍历 Dept 列表，构建树形结构
        for (Dept dept : deps) {
            DeptVo deptVo = voMap.get(dept.getId());
            if (dept.getParent() == null) {
                root = deptVo;  // 找到根节点
            } else {
                DeptVo parentVo = voMap.get(dept.getParent());
                if (parentVo != null) {
                    parentVo.addChild(deptVo);  // 将当前节点添加为父节点的子节点
                }
            }
        }

        return root;  // 返回树的根节点
    }
}




