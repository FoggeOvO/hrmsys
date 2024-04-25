package com.peo.service.impl;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.peo.pojo.Dept;
import com.peo.service.DeptService;
import com.peo.mapper.DeptMapper;
import com.peo.util.JSONUtil;
import com.peo.util.JwtHelper;
import com.peo.vo.DeptVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    private final DeptMapper deptMapper;
    private final JwtHelper jwtHelper;

    public DeptServiceImpl(DeptMapper deptMapper, JwtHelper jwtHelper){
        this.deptMapper = deptMapper;
        this.jwtHelper = jwtHelper;
    }

    @Override
    public JSONArray getDept(String token) {
        Integer userId = jwtHelper.getUserId(token).intValue();
        if (userId.equals(1)) {
            return getAllDept();
        }
        List<Dept> deps = deptMapper.getDep(userId);
        DeptVo root = buildDeptTree(deps);
        JSONObject depJson = JSON.parseObject(root.toString());
        return JSON.parseArray("[" + depJson.toString() + "]");
    }



    @Override
    public JSONArray getAllDept() {
        LambdaQueryWrapper<Dept> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.select(Dept::getDepname, Dept::getParent, Dept::getId, Dept::getDepcode, Dept::getType, Dept::getNote, Dept::getDeleted).eq(Dept::getDeleted, 0);
        ;
        List<Dept> deps = deptMapper.selectList(lambdaQueryWrapper);
        DeptVo root = buildDeptTree(deps);
        JSONObject depJson = JSON.parseObject(root.toString());
        return JSON.parseArray("[" + depJson.toString() + "]");
    }

    @Override
    public List<Integer> getDepIds(String token) {
        JSONArray dept = getDept(token);
        List<Integer> depIds = new ArrayList<>();
        JSONUtil.getDepIds(dept, depIds);
        return depIds;
    }

    private DeptVo buildDeptTree(List<Dept> deps) {
        Map<Integer, DeptVo> voMap = new HashMap<>();
        DeptVo root = null;

        // 首先将所有 Dept 转换为 DeptVo 并存储到 Map 中以便快速查找
        for (Dept dept : deps) {
            voMap.put(dept.getId(), new DeptVo(dept.getId(), dept.getDepname(), dept.getDepcode(), dept.getType(), dept.getNote(), dept.getDeleted()));
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




