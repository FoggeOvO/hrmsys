package com.peo.controller;



import com.peo.annotation.TokenRequired;
import com.peo.service.DeptService;
import com.peo.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("dep")
public class DeptController {
    @Autowired
    DeptService deptService;

    @GetMapping("getDept")
    @TokenRequired
    public Result getDept(){
        return deptService.getDept();
    }
}
