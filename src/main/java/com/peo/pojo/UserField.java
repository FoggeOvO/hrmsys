package com.peo.pojo;


import com.peo.vo.FieldVo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserField {
    private Integer userId;
    private List<FieldVo> fields;

    public UserField(Integer userId) {
        this.userId = userId;
    }
}
