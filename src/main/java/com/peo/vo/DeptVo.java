package com.peo.vo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

public class DeptVo {
    String title;
    Integer key;
    String code;
    Integer type;
    String note;
    Integer deleted;
    List<DeptVo> children = new ArrayList<>();

    public DeptVo(int key, String title) {
        this.key = key;
        this.title = title;
    }

    public DeptVo(Integer key, String title, String code, Integer type, String note, Integer deleted) {
        this.title = title;
        this.key = key;
        this.code = code;
        this.type = type;
        this.note = note;
        this.deleted = deleted;
    }

    public void addChild(DeptVo child) {
        this.children.add(child);
    }

    @Override
    public String toString() {
        return "{" +
                "\"title\":\"" + title + '\"' +
                ", \"key\":" + key +
                ", \"code\":\"" + code + "\"" +
                ", \"type\":" + type +
                ", \"note\":\"" + note + "\"" +
                ", \"status\":" + deleted  +
                ", \"children\":" + children +
                "}";
    }
}
