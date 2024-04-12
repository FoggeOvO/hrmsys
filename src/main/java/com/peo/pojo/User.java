package com.peo.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;

/**
 * @TableName t_user
 */
@Data
@TableName(value ="t_hrm_user")
public class User implements Serializable {
    @TableId
    private Integer id;

    private String username;

    private String password;

    private String type;

    private String gender;

    private String lastname;

    private String level;

    private String workcode;

    private String position;

    private Integer depid;

    private String hiredate;
    private Integer access;

    @TableLogic
    private Integer deleted;
    @Version
    private Integer version;

    private static final long serialVersionUID = 1L;


}