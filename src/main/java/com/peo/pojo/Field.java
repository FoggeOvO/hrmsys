package com.peo.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.Getter;

import java.io.Serializable;

/**
 * @TableName t_filed
 */
@Data
@TableName(value ="t_hrm_cusfield")
public class Field implements Serializable {
    private Integer id;

    private Integer userId;

    private String house;

    private String meal;

    private Integer tech;

    private Integer annul;


    private static final long serialVersionUID = 1L;

}