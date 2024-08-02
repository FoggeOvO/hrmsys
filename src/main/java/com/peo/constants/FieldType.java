package com.peo.constants;

public enum FieldType {
    TEXT("文本",0),CHECKBOX("开关",1),DROPBOX("选择框",2),DATE("日期",3),TIME("时间",4);

    private final int code;
    private final String name;

    FieldType(String name,int code){
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public static String getNameByCode(int code) {
        for (FieldType type : FieldType.values()) {
            if (type.getCode() == code) {
                return type.getName();
            }
        }
        return null; // 或者抛出异常
    }
    public String toString(){
        return this.name + "-" + this.code;
    }
}
