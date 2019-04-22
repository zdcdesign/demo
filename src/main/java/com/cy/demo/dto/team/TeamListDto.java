package com.cy.demo.dto.team;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 队伍列表展示类
 */
public class TeamListDto implements Serializable {

    @ApiModelProperty(value = "队伍id", name = "teamId")
    private Integer teamId;

    @ApiModelProperty(value = "用户id", name = "userId")
    private Integer userId;

    @ApiModelProperty(value = "队长名", name = "userName")
    private String userName;

    @ApiModelProperty(value = "队伍名称", name = "teamName")
    private String teamName;

    @ApiModelProperty(value = "集合时间", name = "gatherTime")
    private String gatherTime;

    @ApiModelProperty(value = "地点", name = "gathierPlace")
    private String gathierPlace;

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getGatherTime() {
        return gatherTime;
    }

    public void setGatherTime(String gatherTime) {
        this.gatherTime = gatherTime;
    }

    public String getGathierPlace() {
        return gathierPlace;
    }

    public void setGathierPlace(String gathierPlace) {
        this.gathierPlace = gathierPlace;
    }
}
