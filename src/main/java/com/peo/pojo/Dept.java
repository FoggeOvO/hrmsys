package com.peo.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;

/**
 * @TableName t_dept
 */
@Data
@TableName(value ="t_hrm_dept")
public class Dept implements Serializable {
    private Integer id;

    private String depname;

    private String depcode;

    private Integer parent;

    private Integer type;

    private String note;

    private Integer visable;

    @TableLogic
    private Integer deleted;
    @Version
    private Integer version;

    private static final long serialVersionUID = 1L;



}