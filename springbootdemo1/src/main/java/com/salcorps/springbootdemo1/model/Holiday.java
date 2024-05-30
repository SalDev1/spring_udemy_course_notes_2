package com.salcorps.springbootdemo1.model;

import lombok.Data;

@Data
public class Holiday extends BaseEntity {
    private  String day;
    private  String reason;
    private  Type type;

    public enum Type {
        FESTIVAL,FEDERAL
    }
}
