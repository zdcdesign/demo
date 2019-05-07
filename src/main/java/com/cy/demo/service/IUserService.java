package com.cy.demo.service;

import com.cy.demo.dto.RestResponse;
import com.cy.demo.dto.power.LoginDto;
import com.cy.demo.dto.power.ModifyPassword;
import com.cy.demo.dto.power.UserPositionDto;
import com.cy.demo.dto.power.UserRegisterDto;
import com.cy.demo.entity.team.UserEo;

/**
 * Created by zhoudachao on 2019/4/23.
 */
public interface IUserService {

    RestResponse register(UserRegisterDto userRegisterDto);

    RestResponse login(LoginDto loginDto);

    UserEo queryUserByName(String username);

    RestResponse updatePass(ModifyPassword modifyPassword);

    RestResponse saveLocation(UserPositionDto userPositionDto);

    RestResponse getLocation();

    RestResponse currentManageTeam();

    RestResponse currentTeam();

    RestResponse historyTeam();
}
