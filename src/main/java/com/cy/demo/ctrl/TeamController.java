package com.cy.demo.ctrl;

import com.cy.demo.base.Constant;
import com.cy.demo.dto.RestResponse;
import com.cy.demo.dto.team.IdReqDto;
import com.cy.demo.dto.team.TeamDetailDto;
import com.cy.demo.dto.team.TeamDto;
import com.cy.demo.service.ITeamService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/team")
public class TeamController {

    @Autowired
    private ITeamService teamService;

    @ApiOperation(value = "新增队伍", notes = "新增队伍")
    @ResponseBody
    @RequestMapping(value = "addTeam", method = RequestMethod.POST)
    public RestResponse addTeam(@RequestBody TeamDto teamDto) {
        teamService.addTeam(teamDto);
        return new RestResponse(0, Constant.SUCCESS);
    }

    @ApiOperation(value = "查看队伍信息", notes = "查看队伍信息")
    @ResponseBody
    @RequestMapping(value = "queryTeamDetail", method = RequestMethod.POST)
    public RestResponse queryTeamDetail(@RequestBody IdReqDto idReqDto) {
        return new RestResponse(0, Constant.SUCCESS, teamService.queryTeamDetail(idReqDto));
    }

}
