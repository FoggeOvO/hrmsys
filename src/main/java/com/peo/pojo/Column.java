package com.peo.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * @TableName t_column
 */
@TableName(value ="t_sys_column")
public class Column implements Serializable {
    private Integer id;

    private String tablename;

    private String columnname;

    private String dataindex;

    private String key;

    private String title;

    private Integer visable;

    private Integer sortkey;

    private Integer showinmain;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTablename() {
        return tablename;
    }

    public void setTablename(String tablename) {
        this.tablename = tablename;
    }

    public String getColumnname() {
        return columnname;
    }

    public void setColumnname(String columnname) {
        this.columnname = columnname;
    }

    public String getDataindex() {
        return dataindex;
    }

    public void setDataindex(String dataindex) {
        this.dataindex = dataindex;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getVisable() {
        return visable;
    }

    public void setVisable(Integer visable) {
        this.visable = visable;
    }

    public Integer getSortkey() {
        return sortkey;
    }

    public void setSortkey(Integer sortkey) {
        this.sortkey = sortkey;
    }

    public Integer getShowinmain() {
        return showinmain;
    }

    public void setShowinmain(Integer showinmain) {
        this.showinmain = showinmain;
    }
}