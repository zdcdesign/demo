package com.cy.demo.dto.team;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 根据id查询的我创建或者我加入的队伍
 */
public class TeamListQueryByIdRespDto implements Serializable {

    @ApiModelProperty(value = "队伍id", name = "teamId")
    private Integer teamId;

    @ApiModelProperty(value = "用户id", name = "userId")
    private Integer userId;

    @ApiModelProperty(value = "队伍名称", name = "teamName")
    private String teamName;

    @ApiModelProperty(value = "用户名", name = "userName")
    private String userName;

    @ApiModelProperty(value = "图片", name = "img")
    private String img;

    @ApiModelProperty(value = "电话", name = "telephone")
    private String telephone;

    @ApiModelProperty(value = "集合时间", name = "gatherTime")
    private String gatherTime;

    @ApiModelProperty(value = "结束时间", name = "teamName")
    private String endTime;

    @ApiModelProperty(value = "集合地点", name = "gatherPlace")
    private String gatherPlace;

    public String getGatherPlace() {
        return gatherPlace;
    }

    public void setGatherPlace(String gatherPlace) {
        this.gatherPlace = gatherPlace;
    }

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getGatherTime() {
        return gatherTime;
    }

    public void setGatherTime(String gatherTime) {
        this.gatherTime = gatherTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
