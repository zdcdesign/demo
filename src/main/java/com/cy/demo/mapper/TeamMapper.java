package com.cy.demo.mapper;

import com.cy.demo.base.BaseMapper;
import com.cy.demo.dto.team.TeamListDto;
import com.cy.demo.dto.team.TeamUserAddReqDto;
import com.cy.demo.entity.team.TeamEo;
import org.apache.ibatis.annotations.Select;

import java.util.List;

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

    /**
     * 获得自增主键
     *
     * @return
     */
    @Select({"<script>" +
            "select user_id FROM tb_team WHERE team_id = ${teamId}; " +
            "</script>"})
    Integer queryIsCaptain(TeamUserAddReqDto teamUserAddReqDto);


    /**
     * 人数加一或减一的方法 flag不为null加一为null减一
     */
    @Select({"<script>" +
            "<if test = \"flag != null  \" >" +
            "UPDATE tb_team SET current_number = current_number + 1 WHERE team_id = #{teamId};" +
            "</if>" +
            "<if test = \"flag == null  \" >" +
            "UPDATE tb_team SET current_number = current_number - 1 WHERE team_id = #{teamId};" +
            "</if>" +
            "</script>"})
    void addOrIncNum(Integer teamId, String flag);

//    SELECT
//    tu.username
//    FROM
//            (
//                    SELECT
//			*
//                    FROM
//                    tb_team AS tt
//                    WHERE
//                    tt.team_name LIKE '%球%'
//                    OR
//                    tt.gathier_place LIKE '口'
//            )
//    AS temp
//
//    JOIN tb_user AS tu ON temp.user_id = tu.id;

    /**
     * 按条件查询
     * 并分页
     *
     * @param keyWord
     */
    @Select({"<script>" +
            "SELECT  temp.team_id as teamId,temp.user_id as userId," +
            "tu.username as userName," +
            " temp.team_name as teamName," +
            //" temp.gather_time as gatherTime, " +
            "DATE_FORMAT(temp.gather_time,'%Y-%m-%d %h:%m') AS gatherTime," +
            "temp.gathier_place as gathierPlace " +
            "FROM( " +
            "SELECT * from tb_team AS tt " +
            "WHERE  " +
            "tt.team_name like concat('%',#{keyWord},'%')" +
            " OR " +
            "tt.gathier_place like concat('%',#{keyWord},'%')" +
            ") AS temp " +
            "JOIN tb_user AS tu ON temp.user_id = tu.id;" +
            "</script>"})
    List<TeamListDto> queryByAddressOrName(String keyWord);
}
