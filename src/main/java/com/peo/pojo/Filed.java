package com.peo.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * @TableName t_filed
 */
@TableName(value ="t_sys_filed")
public class Filed implements Serializable {
    private Integer id;

    private Integer uid;

    private String actconfdata;

    private String costcenter;

    private Integer houseallance;

    private Integer iscn;

    private Integer isconf;

    private Integer istech;

    private Integer mealallance;

    private String national;

    private String remark;

    private Integer salgroup;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getActconfdata() {
        return actconfdata;
    }

    public void setActconfdata(String actconfdata) {
        this.actconfdata = actconfdata;
    }

    public String getCostcenter() {
        return costcenter;
    }

    public void setCostcenter(String costcenter) {
        this.costcenter = costcenter;
    }

    public Integer getHouseallance() {
        return houseallance;
    }

    public void setHouseallance(Integer houseallance) {
        this.houseallance = houseallance;
    }

    public Integer getIscn() {
        return iscn;
    }

    public void setIscn(Integer iscn) {
        this.iscn = iscn;
    }

    public Integer getIsconf() {
        return isconf;
    }

    public void setIsconf(Integer isconf) {
        this.isconf = isconf;
    }

    public Integer getIstech() {
        return istech;
    }

    public void setIstech(Integer istech) {
        this.istech = istech;
    }

    public Integer getMealallance() {
        return mealallance;
    }

    public void setMealallance(Integer mealallance) {
        this.mealallance = mealallance;
    }

    public String getNational() {
        return national;
    }

    public void setNational(String national) {
        this.national = national;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getSalgroup() {
        return salgroup;
    }

    public void setSalgroup(Integer salgroup) {
        this.salgroup = salgroup;
    }
}