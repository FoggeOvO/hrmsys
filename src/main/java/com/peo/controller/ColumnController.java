package com.peo.controller;

import com.peo.annotation.TokenRequired;
import com.peo.service.ColumnService;
import com.peo.util.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("sys")
public class ColumnController {
    private final ColumnService columnService;
    public ColumnController(ColumnService columnService){
        this.columnService = columnService;
    }

    @GetMapping("getAllColumns")
    @TokenRequired
    public Result getAllColumns(){
       return Result.ok(columnService.getAllColumns());
    }
}
