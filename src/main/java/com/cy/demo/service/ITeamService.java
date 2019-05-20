package com.cy.demo.service;

import com.cy.demo.dto.team.*;
import com.cy.demo.entity.team.TeamEo;

import java.util.List;


public interface ITeamService {
    boolean addTeam(TeamDto teamDto);

    TeamDetailDto queryTeamDetail(IdReqDto idReqDto);

    boolean addTeamUser(TeamUserAddReqDto teamUserAddReqDto);

    void deleteTeam(TeamUserAddReqDto teamUserAddReqDto);

    PageInfoRespDto queryAllTeam(PageQueryReqDto pageQueryReqDto);

    List<TeamUserListRespDto> queryTeamUser(IdReqDto idReqDto);

    List<TeamListQueryByIdRespDto> queryListById(IdReqDto idReqDto);

    List<TeamEo> queryTeamByType(PageQueryReqDto pageQueryReqDto);

    List<TeamListQueryByIdRespDto> queryAll();
}
