package com.cy.demo.mapper;

import com.cy.demo.base.BaseMapper;
import com.cy.demo.entity.team.UserTeamEo;
import org.apache.ibatis.annotations.Select;

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
}
