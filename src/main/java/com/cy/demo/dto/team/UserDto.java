package com.cy.demo.dto.team;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class UserDto implements Serializable {

    @ApiModelProperty(value = "用户id", name = "userId")
    private Integer userId;

    @ApiModelProperty(value = "用户姓名", name = "userName")
    private String userName;
}
