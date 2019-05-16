package com.cy.demo.dto.team;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 队伍详情
 */
public class TeamDetailDto implements Serializable {

    @ApiModelProperty(value = "id", name = "id")
    private Integer teamId;

    @ApiModelProperty(value = "队伍名称", name = "teamName")
    private String teamName;

    @ApiModelProperty(value = "队伍简介", name = "teamIntro")
    private String teamIntro;

    @ApiModelProperty(value = "队长id", name = "userId")
    private Integer userId;

    @ApiModelProperty(value = "图片", name = "img")
    private String img;

    @ApiModelProperty(value = "队长名字", name = "userName")
    private String userName;

    @ApiModelProperty(value = "集合时间", name = "gatherTime")
    private String gatherTime;

    @ApiModelProperty(value = "集合地点", name = "gathierPlace")
    private String gathierPlace;

    @ApiModelProperty(value = "开始时间", name = "startTime")
    private String startTime;

    @ApiModelProperty(value = "结束时间", name = "endTime")
    private String endTime;

    @ApiModelProperty(value = "创建时间", name = "endTime")
    private String createTime;

    @ApiModelProperty(value = "修改时间", name = "endTime")
    private String updateTime;

    @ApiModelProperty(value = "预计人数", name = "expectNumber")
    private Integer expectNumber;

    @ApiModelProperty(value = "现有人数", name = "currentNumber")
    private Integer currentNumber;

    @ApiModelProperty(value = "是否过期", name = "currentNumber")
    private Integer overdue;

    @ApiModelProperty(value = "锁定状态", name = "lockedState")
    private Integer lockedState;

    //    队伍中的队员
    private List<TeamUserListRespDto> teamUserList;

    public List<TeamUserListRespDto> getTeamUserList() {
        return teamUserList;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setTeamUserList(List<TeamUserListRespDto> teamUserList) {
        this.teamUserList = teamUserList;
    }

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

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

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getExpectNumber() {
        return expectNumber;
    }

    public void setExpectNumber(Integer expectNumber) {
        this.expectNumber = expectNumber;
    }

    public Integer getCurrentNumber() {
        return currentNumber;
    }

    public void setCurrentNumber(Integer currentNumber) {
        this.currentNumber = currentNumber;
    }

    public Integer getOverdue() {
        return overdue;
    }

    public void setOverdue(Integer overdue) {
        this.overdue = overdue;
    }

    public Integer getLockedState() {
        return lockedState;
    }

    public void setLockedState(Integer lockedState) {
        this.lockedState = lockedState;
    }
}
