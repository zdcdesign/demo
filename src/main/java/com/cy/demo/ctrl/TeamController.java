package com.cy.demo.ctrl;

import com.cy.demo.base.Constant;
import com.cy.demo.dto.RestResponse;
import com.cy.demo.dto.team.*;
import com.cy.demo.service.ITeamService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/team")
public class TeamController {

    @Autowired
    private ITeamService teamService;

    @ApiOperation(value = "新增队伍")
    @ResponseBody
    @RequestMapping(value = "addTeam", method = RequestMethod.POST)
    public RestResponse addTeam(@RequestBody TeamDto teamDto) {
        if (teamService.addTeam(teamDto)) {
            return new RestResponse(0, Constant.SUCCESS);
        } else {
            return new RestResponse(-1, Constant.FAILURE);
        }

    }

    @ApiOperation(value = "查看队伍信息")
    @ResponseBody
    @RequestMapping(value = "queryTeamDetail", method = RequestMethod.POST)
    public RestResponse queryTeamDetail(@RequestBody IdReqDto idReqDto) {
        return new RestResponse(0, Constant.SUCCESS, teamService.queryTeamDetail(idReqDto));
    }

    @ApiOperation(value = "加入队伍")
    @ResponseBody
    @RequestMapping(value = "addTeamUser", method = RequestMethod.POST)
    public RestResponse addTeamUser(@RequestBody TeamUserAddReqDto teamUserAddReqDto) {
        if (teamService.addTeamUser(teamUserAddReqDto)) {
            return new RestResponse(0, Constant.SUCCESS);
        } else {
            return new RestResponse(-1, "加入失败！");
        }

    }

    @ApiOperation(value = "退出队伍（如果是队长退出则解散队伍）")
    @ResponseBody
    @RequestMapping(value = "deleteTeam", method = RequestMethod.POST)
    public RestResponse deleteTeam(@RequestBody TeamUserAddReqDto teamUserAddReqDto) {
        teamService.deleteTeam(teamUserAddReqDto);
        return new RestResponse(0, Constant.SUCCESS);
    }

    @ApiOperation(value = "显示队伍中的队员")
    @ResponseBody
    @RequestMapping(value = "queryTeamUser", method = RequestMethod.POST)
    public RestResponse queryTeamUser(@RequestBody IdReqDto idReqDto) {
//        List<UserDto>
        List<TeamUserListRespDto> teamUserList = teamService.queryTeamUser(idReqDto);
        return new RestResponse(0, Constant.SUCCESS, teamUserList);
    }

    @ApiOperation(value = "查询显示队伍（条件为队伍名称、地点不进行输入查询全部）")
    @ResponseBody
    @RequestMapping(value = "queryTeam", method = RequestMethod.POST)
    public RestResponse queryTeam(@RequestBody PageQueryReqDto pageQueryReqDto) {
        PageInfoRespDto teamList = teamService.queryAllTeam(pageQueryReqDto);
        return new RestResponse(0, Constant.SUCCESS, teamList);
    }
}
