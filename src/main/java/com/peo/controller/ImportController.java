package com.peo.controller;

import com.peo.service.ImportService;
import com.peo.util.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequestMapping("import")
public class ImportController {

    private final ImportService importService;

    public ImportController(ImportService importService){
        this.importService = importService;
    }

    @PostMapping("userImport")
    @ResponseBody
    public Result userImport(@RequestParam("file") MultipartFile file){
        System.out.println("执行导入...文件名 --->" + file.getName() + "," + file.getOriginalFilename());
        try {
            importService.ImportUser(file);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return Result.ok("导入成功!");
    }
}
