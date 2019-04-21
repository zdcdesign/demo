package com.cy.demo.service.imp;

import com.cy.demo.dto.team.IdReqDto;
import com.cy.demo.dto.team.TeamDetailDto;
import com.cy.demo.dto.team.TeamDto;
import com.cy.demo.entity.team.TeamEo;
import com.cy.demo.entity.team.UserTeamEo;
import com.cy.demo.mapper.TeamMapper;
import com.cy.demo.mapper.UserTeamMapper;
import com.cy.demo.service.ITeamService;
import com.cy.demo.utils.TimeCovertUtis;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class TeamService implements ITeamService {

    @Resource
    private TeamMapper teamMapper;

    @Resource
    private UserTeamMapper userTeamMapper;

    //新增队伍方法
    @Override
    public void addTeam(TeamDto teamDto) {
        //TODO 插入之前检查建队人是否有参加有其他冲突的，有的话建队失败
        TeamEo eo = new TeamEo();
        BeanUtils.copyProperties(teamDto, eo);
        //创建时间
        eo.setCreateTime(new Date());
        //新增加，现有队伍人数为1
        eo.setCurrentNumber(1);
        //是否过期新建默认没过期
        eo.setOverdue(0);
        //是否锁定新建默认没锁定
        eo.setLockedState(0);
        teamMapper.insert(eo);
        //获得自增主键
        Integer id = teamMapper.getAutoId();
        //获得主键后添加到关联表中
        UserTeamEo userTeamEo = new UserTeamEo();
        userTeamEo.setTeamId(id);
        userTeamEo.setUserId(teamDto.getUserId());
        userTeamMapper.insert(userTeamEo);
    }

    /**
     * 查询详情
     *
     * @param idReqDto
     * @return
     */
    @Override
    public TeamDetailDto queryTeamDetail(IdReqDto idReqDto) {
        TeamDetailDto detailDto = new TeamDetailDto();
        TeamEo teamEo = new TeamEo();
        teamEo.setTeamId(idReqDto.getTeamId());
        teamEo = teamMapper.selectOne(teamEo);
        // selectByPrimaryKey()在这不可用，该方法默认主键名为id，实际在本表中为teamId
        // TeamEo teamEo1 = teamMapper.selectByPrimaryKey(5);
        BeanUtils.copyProperties(teamEo, detailDto);
        // 几个时间的转化
        detailDto.setCreateTime(TimeCovertUtis.date2String(teamEo.getCreateTime()));
        detailDto.setUpdateTime(teamEo.getUpdateTime() == null ? null : TimeCovertUtis.date2String(teamEo.getUpdateTime()));
        detailDto.setStartTime(TimeCovertUtis.date2String(teamEo.getStartTime()));
        detailDto.setEndTime(TimeCovertUtis.date2String(teamEo.getEndTime()));
        detailDto.setGatherTime(TimeCovertUtis.date2String(teamEo.getGatherTime()));
        return detailDto;
    }
}
