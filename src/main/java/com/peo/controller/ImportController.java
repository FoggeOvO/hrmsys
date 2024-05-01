package com.peo.controller;

import com.peo.util.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("import")
public class ImportController {

    @PostMapping("userImport")
    public Result userImport(MultipartFile file){

        return Result.ok();
    }
}
