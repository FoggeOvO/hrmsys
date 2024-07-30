package com.peo.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @TableName t_sys_field
 */
@TableName(value ="t_sys_field")
@Data
public class Column implements Serializable {
    private Integer id;

    private String fieldValue;

    private String fieldName;

    private Integer fieldWidth;

    private Integer fieldType;

    private Integer selectId;

    private Integer deleted;
    private static final long serialVersionUID = 1L;

}