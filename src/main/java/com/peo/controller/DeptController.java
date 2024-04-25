package com.peo.controller;



import com.alibaba.fastjson2.JSONArray;
import com.peo.annotation.TokenRequired;
import com.peo.service.DeptService;
import com.peo.util.JSONUtil;
import com.peo.util.Result;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("dep")
public class DeptController {
    private final DeptService deptService;

    public DeptController(DeptService deptService){
        this.deptService = deptService;
    }

    @GetMapping("getDept")
    @TokenRequired
    public Result getDept(HttpServletRequest res){
        String token = res.getHeader("token");
        JSONArray depts = deptService.getDept(token);
        return Result.ok(depts);
    }

    @GetMapping("getDepIds")
    @TokenRequired
    public Result getDepIds(HttpServletRequest res){
        String token = res.getHeader("token");
        List<Integer> depIds = deptService.getDepIds(token);
        return Result.ok(depIds);
    }
}
