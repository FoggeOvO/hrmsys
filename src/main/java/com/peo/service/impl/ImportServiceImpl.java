package com.peo.service.impl;

import com.alibaba.excel.EasyExcel;
import com.peo.listener.ImportUserListener;
import com.peo.mapper.UserMapper;
import com.peo.pojo.User;
import com.peo.service.ImportService;
import com.peo.vo.UserVo;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class ImportServiceImpl implements ImportService {
    private final UserMapper userMapper;

    public ImportServiceImpl(UserMapper userMapper){
        this.userMapper = userMapper;
    }
    @Override
    public void ImportUser(MultipartFile file) throws IOException {
        System.out.println("开始读取数据,文件名为 --->" + file.getName());
        EasyExcel.read(file.getInputStream(), UserVo.class, new ImportUserListener(userMapper)).sheet().doRead();
    }
}
