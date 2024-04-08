package com.peo.pojo;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;

/**
 * @TableName t_dept
 */
@TableName(value ="t_hrm_dept")
public class Dept implements Serializable {
    private Integer id;

    private String depname;

    private String depcode;

    private Integer parent;

    private String type;

    private Integer visable;

    @TableLogic
    private Integer deleted;
    @Version
    private Integer version;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepname() {
        return depname;
    }

    public void setDepname(String depname) {
        this.depname = depname;
    }

    public String getDepcode() {
        return depcode;
    }

    public void setDepcode(String depcode) {
        this.depcode = depcode;
    }

    public Integer getParent() {
        return parent;
    }

    public void setParent(Integer parent) {
        this.parent = parent;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getVisable() {
        return visable;
    }

    public void setVisable(Integer visable) {
        this.visable = visable;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }
}