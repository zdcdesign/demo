package com.cy.demo.ctrl;

import com.cy.demo.base.Constant;
import com.cy.demo.dto.RestResponse;
import com.cy.demo.dto.team.*;
import com.cy.demo.entity.team.TeamEo;
import com.cy.demo.entity.team.UserEo;
import com.cy.demo.service.ITeamService;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
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

        //TODO 1111111
        // UserEo userEo = (UserEo) SecurityUtils.getSubject().getPrincipal();
        // System.out.println(userEo.getUserName());
        //   teamDto.setUserId(2015123);
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
        List<TeamUserListRespDto> teamUserList = teamService.queryTeamUser(idReqDto);
        TeamDetailDto detailDto = teamService.queryTeamDetail(idReqDto);
        detailDto.setTeamUserList(teamUserList);
        return new RestResponse(0, Constant.SUCCESS, detailDto);
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

    @ApiOperation(value = "根据id查询我创建或加入的队伍")
    @ResponseBody
    @RequestMapping(value = "queryListById", method = RequestMethod.POST)
    public RestResponse queryListById(@RequestBody IdReqDto idReqDto) {
        List<TeamListQueryByIdRespDto> teamListQueryByIdRespDto = teamService.queryListById(idReqDto);
        if (teamListQueryByIdRespDto == null && teamListQueryByIdRespDto.size() == 0) {
            return new RestResponse(1, "没有数据！");
        } else {
            return new RestResponse(0, Constant.SUCCESS, teamListQueryByIdRespDto);
        }
    }

    @ApiOperation(value = "通过搜索条件搜索相应类型的组队")
    @ResponseBody
    @RequestMapping(value = "queryTeamByType", method = RequestMethod.POST)
    public RestResponse queryTeamByType(@RequestBody PageQueryReqDto pageQueryReqDto) {
        List<TeamEo> teamList = teamService.queryTeamByType(pageQueryReqDto);
        for (TeamEo teamEo:teamList){
            System.out.println("根据关键词搜索:"+teamEo.getTeamName());
        }
        return new RestResponse(0, Constant.SUCCESS, teamList);
    }
}
