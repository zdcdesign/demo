package com.cy.demo.mapper;

import com.cy.demo.base.BaseMapper;
import com.cy.demo.entity.team.TeamEo;
import org.apache.ibatis.annotations.Select;

public interface TeamMapper extends BaseMapper<TeamEo> {

    /**
     * 获得自增主键
     *
     * @return
     */
    @Select({"<script>" +
            "select last_insert_id() " +
            "</script>"})
    Integer getAutoId();

}
