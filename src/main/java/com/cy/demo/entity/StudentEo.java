package com.cy.demo.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


import javax.persistence.Column;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "t_admin")
@ApiModel(value = "StudentEo", discriminator = "学生表")
public class StudentEo implements Serializable {

    @ApiModelProperty(value = "id", name = "id")
    @Column(name = "userId")
    private String id;

    @ApiModelProperty(value = "姓名", name = "name")
    @Column(name = "userName")
    private String name;

    @ApiModelProperty(value = "密码", name = "userPw")
    @Column(name = "userPw")
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
