package com.cy.demo.entity.team;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Table(name = "tb_team")
@ApiModel(value = "TeamEo", discriminator = "组队表")
public class TeamEo implements Serializable {
    @ApiModelProperty(value = "teamId", name = "teamId")
    @Column(name = "team_id")
    private Integer teamId;

    @ApiModelProperty(value = "队伍名称", name = "teamName")
    @Column(name = "team_name")
    private String teamName;

    @ApiModelProperty(value = "队伍简介", name = "teamIntro")
    @Column(name = "team_intro")
    private String teamIntro;

    @ApiModelProperty(value = "队长id", name = "userId")
    @Column(name = "user_id")
    private Integer userId;

    @ApiModelProperty(value = "创建时间", name = "createTime")
    @Column(name = "create_time")
    private Date createTime;

    @ApiModelProperty(value = "修改时间", name = "updateTime")
    @Column(name = "update_time")
    private Date updateTime;

    @ApiModelProperty(value = "集合时间", name = "gatherTime")
    @Column(name = "gather_time")
    private Date gatherTime;

    @ApiModelProperty(value = "集合地点", name = "gathierPlace")
    @Column(name = "gathier_place")
    private String gathierPlace;

    @ApiModelProperty(value = "开始时间", name = "startTime")
    @Column(name = "start_time")
    private Date startTime;

    @ApiModelProperty(value = "结束时间", name = "endTime")
    @Column(name = "end_Time")
    private Date endTime;

    @ApiModelProperty(value = "预计人数", name = "expectNumber")
    @Column(name = "expect_number")
    private Integer expectNumber;

    @ApiModelProperty(value = "现有人数", name = "currentNumber")
    @Column(name = "current_number")
    private Integer currentNumber;

    @ApiModelProperty(value = "是否过期", name = "currentNumber")
    @Column(name = "overdue")
    private Integer overdue;

    @ApiModelProperty(value = "锁定状态", name = "lockedState")
    @Column(name = "locked_state")
    private Integer lockedState;

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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
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
