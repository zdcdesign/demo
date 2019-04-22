package com.cy.demo.dto.team;

import java.io.Serializable;

public class TeamUserAddReqDto implements Serializable {
    //队伍编号
    private Integer teamId;
    //用户编号
    private Integer userId;

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
}
