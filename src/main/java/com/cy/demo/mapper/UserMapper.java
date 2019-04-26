package com.cy.demo.mapper;

import com.cy.demo.base.BaseMapper;
import com.cy.demo.entity.team.TeamEo;
import com.cy.demo.entity.team.UserEo;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper extends BaseMapper<UserEo> {

    /**
     * 获得name
     *
     * @param userId
     * @return
     */
    @Select({"<script>" +
            "select username from tb_user where id = #{userId};" +
            "</script>"})
    String queryNameById(Integer userId);

    /**
     * 通过用户名查询用户实体
     * @param username
     * @return
     */
    @Select({"<script>" +
            "select * from tb_user where username = #{username};" +
            "</script>"})
    UserEo queryUserByName(String username);

    /**
     * 通过用户id查询当前用户管理的队伍
     * @param id
     * @return
     */
    @Select({"<script>" +
            "select * from tb_team where user_id = #{id};" +
            "</script>"})
    List<TeamEo> queryTeamByUserId(Integer id);

    /**
     *
     * @param id
     * @return
     */
    @Select({"<script>" +
            "SELECT b.* FROM tb_user a,tb_team b,user_team c WHERE a.id=c.user_id AND c.team_id=b.team_id AND a.id=#{id}" +
            "</script>"})
    List<TeamEo> querycurrentTeamByUserId(Integer id);
}
