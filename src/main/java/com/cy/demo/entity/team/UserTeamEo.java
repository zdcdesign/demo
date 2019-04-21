package com.cy.demo.entity.team;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "user_team")
@ApiModel(value = "UserTeamEo", discriminator = "组队用户中间表")
public class UserTeamEo implements Serializable {

    @ApiModelProperty(value = "teamId", name = "teamId")
    @Column(name = "team_id")
    private Integer teamId;

    @ApiModelProperty(value = "userId", name = "userId")
    @Column(name = "user_id")
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
