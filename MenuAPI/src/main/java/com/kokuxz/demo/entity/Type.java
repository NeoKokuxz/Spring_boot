package com.kokuxz.demo.entity;

public class Type {
    private String type;
    //private Long id;

    public Type(){}

    public Type(String name) {
        this.type = name;
        //this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String name) {
        this.type = name;
    }

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
}
