package com.cy.demo.ctrl;

import com.cy.demo.base.Constant;
import com.cy.demo.dto.RestResponse;
import com.cy.demo.dto.team.IdReqDto;
import com.cy.demo.dto.team.TeamListQueryByIdRespDto;
import com.cy.demo.entity.invite.InviteEo;
import com.cy.demo.service.IInviteService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by zhoudachao on 2019/5/17.
 */
@RestController
@RequestMapping("/invite")
public class InviteController {

    @Autowired
    private IInviteService iInviteService;

    @ApiOperation(value = "根据id查询我的所有邀请")
    @ResponseBody
    @RequestMapping(value = "queryInviteById", method = RequestMethod.POST)
    public RestResponse queryInviteById(@RequestBody IdReqDto idReqDto) {
        List<InviteEo> teamListQueryByIdRespDto = iInviteService.queryInviteById(idReqDto);
        if (teamListQueryByIdRespDto == null && teamListQueryByIdRespDto.size() == 0) {
            return new RestResponse(1, "没有数据！");
        } else {
            return new RestResponse(0, Constant.SUCCESS, teamListQueryByIdRespDto);
        }
    }

}
