package com.peo.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @TableName t_filed
 */
@Data
@TableName(value ="t_hrm_cusfield")
public class CustomerField implements Serializable {
    private Integer id;

    private Integer userId;

    private String field1;

    private String field2;

    private Integer field3;

    private Integer field4;


    private static final long serialVersionUID = 1L;

}