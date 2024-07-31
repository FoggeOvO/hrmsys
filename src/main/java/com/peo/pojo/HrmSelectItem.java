package com.peo.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.Getter;

import java.io.Serializable;

/**
 * @TableName t_hrm_selectitem
 */

@TableName(value ="t_hrm_selectitem")
@Data
public class HrmSelectItem implements Serializable {
    private Integer id;

    private Integer mainid;

    private Integer selectValue;

    private String selectName;

    private Integer deleted;

    private static final long serialVersionUID = 1L;

}