package com.cy.demo.service;

import com.cy.demo.dto.team.IdReqDto;
import com.cy.demo.dto.team.TeamDetailDto;
import com.cy.demo.dto.team.TeamDto;

public interface ITeamService {
    void addTeam(TeamDto teamDto);

    TeamDetailDto queryTeamDetail(IdReqDto idReqDto);
}
