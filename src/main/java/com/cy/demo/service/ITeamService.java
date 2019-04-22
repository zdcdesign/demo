package com.cy.demo.service;

import com.cy.demo.dto.team.*;


public interface ITeamService {
    void addTeam(TeamDto teamDto);

    TeamDetailDto queryTeamDetail(IdReqDto idReqDto);

    void addTeamUser(TeamUserAddReqDto teamUserAddReqDto);

    void deleteTeam(TeamUserAddReqDto teamUserAddReqDto);

    PageInfoRespDto queryAllTeam(PageQueryReqDto pageQueryReqDto);
}
