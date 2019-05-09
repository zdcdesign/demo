package com.cy.demo.dto.team;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 显示队伍中的队员
 */
public class TeamUserListRespDto implements Serializable {

    @ApiModelProperty(value = "队员id", name = "userId")
    private Integer userId;

    @ApiModelProperty(value = "用户名", name = "userName")
    private String userName;

    @ApiModelProperty(value = "电话", name = "telephone")
    private String telephone;

    @ApiModelProperty(value = "图片", name = "img")
    private String img;

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
