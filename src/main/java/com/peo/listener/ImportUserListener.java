package com.peo.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

import com.peo.mapper.UserMapper;
import com.peo.vo.UserVo;


import java.util.ArrayList;
import java.util.List;

public class ImportUserListener extends AnalysisEventListener<UserVo> {
    private static final int BATCH_COUNT = 10000;
    private List<UserVo> list = new ArrayList<>();

    private final UserMapper userMapper;

    public ImportUserListener(UserMapper userMapper){
        this.userMapper = userMapper;
    }
    @Override
    public void invoke(UserVo user, AnalysisContext analysisContext) {
        System.out.println(user.toString());
        list.add(user);
        if(list.size() >= BATCH_COUNT){
            saveData(list);
            //加入执行后清空list
            list.clear();
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        saveData(list);
    }

    private void saveData(List<UserVo> list) {
        if(!list.isEmpty()){
            //TODO:这里需要加入将List<User>写入数据库的代码
            userMapper.importData(list);
            System.out.println("当前加入了:" + list.size() + "条数据");
        }
    }
}
