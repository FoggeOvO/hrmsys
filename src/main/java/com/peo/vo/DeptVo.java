package com.peo.vo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

public class DeptVo {
    String title;
    Integer key;
    List<DeptVo> children = new ArrayList<>();

    public DeptVo(int key, String title) {
        this.key = key;
        this.title = title;
    }

    public void addChild(DeptVo child) {
        this.children.add(child);
    }

    @Override
    public String toString() {
        return "{" +
                "\"title\":\"" + title + '\"' +
                ", \"key\":" + key +
                ", \"children\":" + children +
                "}";
    }


}
