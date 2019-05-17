package com.cy.demo.service.imp;

import com.cy.demo.dto.team.IdReqDto;
import com.cy.demo.entity.invite.InviteEo;
import com.cy.demo.mapper.InviteMapper;
import com.cy.demo.mapper.TeamMapper;
import com.cy.demo.service.IInviteService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zhoudachao on 2019/5/17.
 */
@Service
public class InviteService implements IInviteService{

    @Resource
    private InviteMapper inviteMapper;

    @Override
    public List<InviteEo> queryInviteById(IdReqDto idReqDto) {
        return inviteMapper.queryInviteById(idReqDto.getUserId());
    }
}
