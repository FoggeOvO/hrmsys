package com.peo.pojo;

import com.baomidou.mybatisplus.annotation.*;
import com.peo.vo.FieldVo;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

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

    private Integer status;

    private Integer access;

    private UserField userField;

    @TableLogic
    private Integer deleted;
    @Version
    private Integer version;

    private static final long serialVersionUID = 1L;


}