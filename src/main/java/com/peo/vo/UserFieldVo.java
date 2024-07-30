package com.peo.vo;


import lombok.Data;

import java.util.List;

@Data
public class UserFieldVo {
    private Long userId;
    private List<FieldVo> fields;
}
