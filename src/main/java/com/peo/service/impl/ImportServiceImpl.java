package com.peo.service.impl;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.peo.listener.UserListener;
import com.peo.pojo.User;
import com.peo.service.ImportService;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public class ImportServiceImpl implements ImportService {
    @Override
    public void ImportUser(MultipartFile file) throws IOException {
        EasyExcel.read(file.getInputStream(), User.class, new UserListener(new User())).doReadAll();
    }
}
