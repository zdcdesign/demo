package com.cy.demo.mapper;

import com.cy.demo.base.BaseMapper;
import com.cy.demo.entity.team.UserEo;
import org.apache.ibatis.annotations.Select;

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
}
