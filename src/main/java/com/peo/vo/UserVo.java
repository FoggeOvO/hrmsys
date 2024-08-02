package com.peo.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserVo {
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

    private List<FieldVo> fields;

}
