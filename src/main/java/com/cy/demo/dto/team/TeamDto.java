package com.cy.demo.dto.team;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

public class TeamDto implements Serializable {
    @ApiModelProperty(value = "队伍名称", name = "teamName")
    private String teamName;

    @ApiModelProperty(value = "队伍简介", name = "teamIntro")
    private String teamIntro;

    @ApiModelProperty(value = "队长id", name = "userId")
    private Integer userId;

    @ApiModelProperty(value = "集合时间", name = "gatherTime")
    private Date gatherTime;

    @ApiModelProperty(value = "集合地点", name = "gathierPlace")
    private String gathierPlace;

    @ApiModelProperty(value = "开始时间", name = "startTime")

    private Date startTime;

    @ApiModelProperty(value = "结束时间", name = "endTime")
    private Date endTime;

    @ApiModelProperty(value = "预计人数", name = "expectNumber")
    private Integer expectNumber;

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamIntro() {
        return teamIntro;
    }

    public void setTeamIntro(String teamIntro) {
        this.teamIntro = teamIntro;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getGatherTime() {
        return gatherTime;
    }

    public void setGatherTime(Date gatherTime) {
        this.gatherTime = gatherTime;
    }

    public String getGathierPlace() {
        return gathierPlace;
    }

    public void setGathierPlace(String gathierPlace) {
        this.gathierPlace = gathierPlace;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getExpectNumber() {
        return expectNumber;
    }

    public void setExpectNumber(Integer expectNumber) {
        this.expectNumber = expectNumber;
    }
}
