package com.peo.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.peo.pojo.User;

import java.util.ArrayList;
import java.util.List;

public class UserListener extends AnalysisEventListener<User> {
    private static final int BATCH_COUNT = 10000;
    private List<User> list = new ArrayList<>();

    private User user;

    public UserListener(User user){
        this.user = user;
    }
    @Override
    public void invoke(User user, AnalysisContext analysisContext) {
        System.out.println(user.toString());
        list.add(user);
        if(list.size() >= BATCH_COUNT){
            saveData(list);
        }
    }

    private void saveData(List<User> list) {
        if(!list.isEmpty()){
            //TODO:这里需要加入将List<User>写入数据库的代码
            //加入执行后清空list
            list.clear();
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
