package com.cy.demo.mapper;

import com.cy.demo.base.BaseMapper;
import com.cy.demo.entity.StudentEo;
import com.cy.demo.entity.invite.InviteEo;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by zhoudachao on 2019/5/17.
 */
public interface InviteMapper extends BaseMapper<InviteEo> {

    //SELECT * FROM tb_invite WHERE state=0 ORDER BY invite_time desc

    @Select({"<script>" +
            "SELECT * FROM tb_invite WHERE invite_id = #{userId} AND state=0 ORDER BY invite_time desc"
            +"</script>"})
    List<InviteEo> queryInviteById(Integer userId);

}
