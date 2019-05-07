package com.cy.demo.service.imp;

import com.cy.demo.base.Constant;
import com.cy.demo.dto.RestResponse;
import com.cy.demo.dto.power.LoginDto;
import com.cy.demo.dto.power.ModifyPassword;
import com.cy.demo.dto.power.UserPositionDto;
import com.cy.demo.dto.power.UserRegisterDto;
import com.cy.demo.entity.team.TeamEo;
import com.cy.demo.entity.team.UserEo;
import com.cy.demo.mapper.TeamMapper;
import com.cy.demo.mapper.UserMapper;
import com.cy.demo.mapper.UserTeamMapper;
import com.cy.demo.service.IUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by zhoudachao on 2019/4/23.
 */
@Service
public class UserService implements IUserService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private TeamMapper teamMapper;

    @Resource
    private UserTeamMapper userTeamMapper;

    @Override
    public RestResponse register(UserRegisterDto userRegisterDto) {

        //校验用户名 是否重复
        UserEo checkUser = userMapper.queryUserByName(userRegisterDto.getUserName());
        if (checkUser!=null){
            return new RestResponse(1,"用户名重复");
        }
        //校验电话号码是否为空
        UserEo phoneUser = userMapper.queryUserByTelephone(userRegisterDto.getTelephone());
        if (phoneUser!=null){
            return new RestResponse(1,"该电话已被其他用户使用");
        }

        UserEo userEo = new UserEo();
        Md5Hash md5Hash = new Md5Hash(userRegisterDto.getPassword(),userRegisterDto.getUserName());

        userEo.setUserName(userRegisterDto.getUserName());

        userEo.setPassword(md5Hash.toString());
        userEo.setTelephone(userRegisterDto.getTelephone());
        userEo.setCreated(new Date());
        userEo.setUpdated(new Date());
        userEo.setRemark("新建用户");
        userEo.setName(userRegisterDto.getName());
        userEo.setSchool(userRegisterDto.getSchool());
        userEo.setStudentId(userRegisterDto.getStudentId());
        userEo.setAcademy(userRegisterDto.getAcademy());
        userEo.setMajor(userRegisterDto.getMajor());
        userEo.setImg(userRegisterDto.getImg());

        userMapper.insert(userEo);

        return new RestResponse(0, Constant.SUCCESS);
    }

    @Override
    public RestResponse login(LoginDto loginDto) {
        //校验用户输入的账号密码是否为空
        if(loginDto.getUserName().isEmpty()){
            return new RestResponse(1,"用户名为空");
        }else if (loginDto.getPassword().isEmpty()){
            return new RestResponse(1,"密码为空");
        }
        //1.登录
       try {
           Subject subject = SecurityUtils.getSubject();
           //2.封装用户信息
           UsernamePasswordToken token = new UsernamePasswordToken(loginDto.getUserName(),loginDto.getPassword());
           //3.执行登录方法
           subject.login(token);
           if(subject.getPrincipal()==null){
               return new RestResponse(1,"登录异常");
           }

          if (loginDto.getLongitude()==null||loginDto.getLatitude()==null){
               return new RestResponse(1,"登录位置信息异常，请允许获取位置信息");
           }
           System.out.println("当前用户经度:"+loginDto.getLongitude());
           System.out.println("当前用户纬度:"+loginDto.getLatitude());
           UserEo userEo = (UserEo) SecurityUtils.getSubject().getPrincipal();
           userEo.setLongitude(loginDto.getLongitude());
           userEo.setLatitude(loginDto.getLatitude());
           System.out.println("当前用户id:"+userEo.getId());
           userMapper.updateUserById(loginDto.getLatitude(),loginDto.getLongitude(),userEo.getId());
           System.out.println("登录逻辑执行完毕，返回登陆成功信息in");
           return new RestResponse(0, Constant.SUCCESS);
       }catch (Exception e){
           e.printStackTrace();
           return new RestResponse(1,"登录异常");
       }


    }

    @Override
    public UserEo queryUserByName(String username) {
        return userMapper.queryUserByName(username);
    }

    @Override
    public RestResponse updatePass(ModifyPassword modifyPassword) {

        if (modifyPassword.getNewPassword().isEmpty()||modifyPassword.getCheckPassword().isEmpty()||!modifyPassword.getCheckPassword().equals(modifyPassword.getNewPassword())){
            return new RestResponse(1,"新密码输入异常");
        }

        //1.登录
        try {
            UserEo userEo = (UserEo) SecurityUtils.getSubject().getPrincipal();

            if (userEo!=null){

                Md5Hash md5Hash = new Md5Hash(modifyPassword.getNewPassword(),userEo.getUserName());

                userEo.setPassword(md5Hash.toString());

                userMapper.updateByPrimaryKey(userEo);
                return new RestResponse(0, Constant.SUCCESS);
            }

            return new RestResponse(1,"用户没有登录");
        }catch (Exception e){
            e.printStackTrace();
            return new RestResponse(1,"密码更新异常");
        }

    }

    @Override
    public RestResponse saveLocation(UserPositionDto userPositionDto) {

        if (userPositionDto.getLongitude()==null||userPositionDto.getLatitude()==null){
            return new RestResponse(1,"位置信息异常");
        }

        //1.保存用户当前地理位置
        try {
            UserEo userEo = (UserEo) SecurityUtils.getSubject().getPrincipal();
            userEo.setLongitude(userPositionDto.getLongitude());
            userEo.setLatitude(userPositionDto.getLatitude());
            userMapper.updateByPrimaryKey(userEo);

            return new RestResponse(0, Constant.SUCCESS);
        }catch (Exception e){
            return new RestResponse(1,"密码更新异常");
        }

    }

    @Override
    public RestResponse getLocation() {
        try {
            UserEo userEo = (UserEo) SecurityUtils.getSubject().getPrincipal();
            UserPositionDto userPositionDto = new UserPositionDto();
            userPositionDto.setLatitude(userEo.getLatitude());
            userPositionDto.setLongitude(userEo.getLongitude());

            return new RestResponse(0, Constant.SUCCESS,userPositionDto);
        }catch (Exception e){
            return new RestResponse(1,"获取地理位置信息异常");
        }

    }

    @Override
    public RestResponse currentManageTeam() {
        try {
            UserEo userEo = (UserEo) SecurityUtils.getSubject().getPrincipal();
            List<TeamEo> teamEoList = userMapper.queryTeamByUserId(userEo.getId());

            List<TeamEo> nowTeamList = new ArrayList<>();

            Date nowDate = new Date();
            for (TeamEo team:teamEoList){
                if (nowDate.compareTo(team.getGatherTime())<0){
                    nowTeamList.add(team);
                }
            }

            return new RestResponse(0, Constant.SUCCESS,nowTeamList);
        }catch (Exception e){
            return new RestResponse(1,"获取管理队伍信息异常");
        }
    }

    @Override
    public RestResponse currentTeam() {
        try {
            UserEo userEo = (UserEo) SecurityUtils.getSubject().getPrincipal();
            List<TeamEo> teamEoList = userMapper.querycurrentTeamByUserId(userEo.getId());

            List<TeamEo> nowTeamList = new ArrayList<>();

            Date nowDate = new Date();
            for (TeamEo team:teamEoList){
                if (nowDate.compareTo(team.getGatherTime())<0){
                    nowTeamList.add(team);
                }
            }

            return new RestResponse(0, Constant.SUCCESS,nowTeamList);
        }catch (Exception e){
            return new RestResponse(1,"获取当前加入队伍信息异常");
        }
    }

    @Override
    public RestResponse historyTeam() {
        try {
            UserEo userEo = (UserEo) SecurityUtils.getSubject().getPrincipal();
            List<TeamEo> teamEoList = userMapper.querycurrentTeamByUserId(userEo.getId());

            List<TeamEo> historyTeamList = new ArrayList<>();

            Date nowDate = new Date();
            for (TeamEo team:teamEoList){
                if (nowDate.compareTo(team.getGatherTime())>0){
                    historyTeamList.add(team);
                }
            }

            return new RestResponse(0, Constant.SUCCESS,historyTeamList);
        }catch (Exception e){
            return new RestResponse(1,"获取历史队伍信息异常");
        }
    }


}
