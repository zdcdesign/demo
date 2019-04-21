package com.cy.demo.dto.team;

import java.io.Serializable;

public class IdReqDto implements Serializable {
    private Integer teamId;

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }
}
