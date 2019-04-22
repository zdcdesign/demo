package com.cy.demo.service.imp;

import com.cy.demo.dto.team.*;
import com.cy.demo.entity.team.TeamEo;
import com.cy.demo.entity.team.UserTeamEo;
import com.cy.demo.mapper.TeamMapper;
import com.cy.demo.mapper.UserMapper;
import com.cy.demo.mapper.UserTeamMapper;
import com.cy.demo.service.ITeamService;
import com.cy.demo.utils.TimeCovertUtis;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TeamService implements ITeamService {

    @Resource
    private TeamMapper teamMapper;

    @Resource
    private UserTeamMapper userTeamMapper;

    @Resource
    private UserMapper userMapper;

    //新增队伍方法
    @Override
    public void addTeam(TeamDto teamDto) {
        //TODO 插入之前检查建队人是否有参加有其他冲突的，有的话建队失败
        TeamEo eo = new TeamEo();
        BeanUtils.copyProperties(teamDto, eo);
        eo.setGatherTime(TimeCovertUtis.string2Date(teamDto.getGatherTime()));
        eo.setStartTime(TimeCovertUtis.string2Date(teamDto.getStartTime()));
        eo.setEndTime(TimeCovertUtis.string2Date(teamDto.getEndTime()));
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

    /**
     * 加入队伍
     *
     * @param teamUserAddReqDto
     */
    @Override
    public void addTeamUser(TeamUserAddReqDto teamUserAddReqDto) {
        //TODO 再加入之前判断是否存在时间冲突 同时判断是否已经满人的情况
        UserTeamEo userTeamEo = new UserTeamEo();
        BeanUtils.copyProperties(teamUserAddReqDto, userTeamEo);
        userTeamMapper.insert(userTeamEo);
        //TODO 加入成功之后该队伍的已有人数加一
        teamMapper.addOrIncNum(teamUserAddReqDto.getTeamId(), new String("1"));
    }

    /**
     * 退出队伍
     *
     * @param teamUserAddReqDto
     */
    @Override
    public void deleteTeam(TeamUserAddReqDto teamUserAddReqDto) {
        //查询要退出的人是否为队长
        Integer userId = teamMapper.queryIsCaptain(teamUserAddReqDto);
        if (userId != null && userId.equals(teamUserAddReqDto.getUserId())) {
            //是，将队伍及关联表相关信息删除
            //先将关联表中信息删除
            userTeamMapper.deleteByTeamId(teamUserAddReqDto);
            //再将队伍信息删除
            TeamEo eo = new TeamEo();
            eo.setTeamId(teamUserAddReqDto.getTeamId());
            teamMapper.delete(eo);
        } else {
            //不是队长根据teamId和userId删除
            UserTeamEo userTeamEo = new UserTeamEo();
            BeanUtils.copyProperties(teamUserAddReqDto, userTeamEo);
            userTeamMapper.delete(userTeamEo);
            //TODO 同时队伍已有人数减一
            teamMapper.addOrIncNum(teamUserAddReqDto.getTeamId(), null);
        }

    }

    /**
     * 列表显示队伍
     *
     * @return
     */
    @Override
    public PageInfoRespDto queryAllTeam(PageQueryReqDto pageQueryReqDto) {
        //分页返回
        PageInfoRespDto infoRespDto = new PageInfoRespDto();
        //用pagehelper进行分页
        PageHelper.startPage(pageQueryReqDto.getPageNum(), pageQueryReqDto.getPageSize());
        //判断查询条件是否为空或者空字符串
        if (pageQueryReqDto.getKeyWord() != null || ("").equals(pageQueryReqDto.getKeyWord())) {
            //查询
            List<TeamListDto> teamListDtoList = teamMapper.
                    queryByAddressOrName(pageQueryReqDto.getKeyWord());
            PageInfo info = new PageInfo(teamListDtoList);
            infoRespDto.setTotal(new Long(info.getTotal()).intValue());
            infoRespDto.setTotalPage(info.getPages());
            infoRespDto.setPageList(teamListDtoList);
            return infoRespDto;
        } else {
            //查询出所有的队伍
            List<TeamEo> list = teamMapper.selectAll();
            //总页数总条数
            PageInfo info = new PageInfo(list);
            infoRespDto.setTotal(new Long(info.getTotal()).intValue());
            infoRespDto.setTotalPage(info.getPages());
            //获得分页后的list，填充用户信息返回
            List<TeamListDto> teamListDto = new ArrayList<>(15);
            for (TeamEo eo : list) {
                TeamListDto dto = new TeamListDto();
                BeanUtils.copyProperties(eo, dto);
                dto.setGatherTime(TimeCovertUtis.date2String(eo.getGatherTime()));
                //查询队长名进行添加
                String name = userMapper.queryNameById(eo.getUserId());
                dto.setUserName(name);
                teamListDto.add(dto);
            }
            infoRespDto.setPageList(teamListDto);
            return infoRespDto;
        }
    }
}
