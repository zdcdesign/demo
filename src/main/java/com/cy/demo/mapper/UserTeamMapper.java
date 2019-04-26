package com.cy.demo.mapper;

import com.cy.demo.base.BaseMapper;
import com.cy.demo.dto.team.TeamTimeDto;
import com.cy.demo.dto.team.TeamUserAddReqDto;
import com.cy.demo.entity.team.UserTeamEo;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserTeamMapper extends BaseMapper<UserTeamEo> {
    /**
     * 关联表中添加
     *
     * @param id
     * @param userId
     */
    @Select({"<script>" +
            "insert into user_team values(#{id},#{userId});" +
            "</script>"})
    void insertUserTeam(Integer id, Integer userId);

    /**
     * 根据teamID删除关联表信息
     *
     * @param teamUserAddReqDto
     */
    @Select({"<script>" +
            "delete from user_team where team_id = #{teamId};" +
            "</script>"})
    void deleteByTeamId(TeamUserAddReqDto teamUserAddReqDto);


    /**
     * 查询队伍信息中的三个时间
     *
     * @param id
     * @return
     */
    @Select({"<script>" +
            "SELECT " +
            " start_time startTime, " +
            " gather_time gatherTime, " +
            " end_time endTime " +
            "FROM " +
            " tb_team AS tt " +
            "JOIN user_team AS ut ON tt.team_id = ut.team_id " +
            "WHERE " +
            " ut.user_id = #{id};" +
            "</script>"})
    List<TeamTimeDto> queryTime(Integer id);

}
