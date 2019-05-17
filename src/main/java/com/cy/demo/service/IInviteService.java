package com.cy.demo.service;

import com.cy.demo.dto.team.IdReqDto;
import com.cy.demo.entity.invite.InviteEo;

import java.util.List;

/**
 * Created by zhoudachao on 2019/5/17.
 */
public interface IInviteService {
    List<InviteEo> queryInviteById(IdReqDto idReqDto);
}
