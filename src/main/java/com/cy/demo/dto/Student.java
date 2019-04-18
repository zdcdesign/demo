package com.cy.demo.dto;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class Student implements Serializable {

    @ApiModelProperty(value = "id", name = "id")
    private String id;

    @ApiModelProperty(value = "学生姓名", name = "name")
    private String name;

    @ApiModelProperty(value = "学生密码", name = "userPw")
    private String userPw;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserPw() {
        return userPw;
    }

    public void setUserPw(String userPw) {
        this.userPw = userPw;
    }
}
