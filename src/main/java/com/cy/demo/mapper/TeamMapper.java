package com.cy.demo.mapper;

import com.cy.demo.base.BaseMapper;
import com.cy.demo.dto.team.*;
import com.cy.demo.entity.team.TeamEo;
import org.apache.ibatis.annotations.Param;
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
    void addOrIncNum(@Param("teamId") Integer teamId, @Param("flag") String flag);

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
            "DATE_FORMAT(temp.gather_time,'%Y-%m-%d %h:%i') AS gatherTime," +
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

    /**
     * 查询队伍中的队友
     *
     * @param idReqDto
     */
    @Select({"<script>" +
            "SELECT " +
            " id as userId, " +
            " username as userName, " +
            " telephone,  " +
            " img " +
            "FROM " +
            "  tb_user " +
            "WHERE " +
            "  id IN ( " +
            "  SELECT " +
            "      user_id AS id " +
            "  FROM " +
            "      user_team " +
            "  WHERE " +
            "    team_id = #{teamId} " +
            "  ); " +
            "</script>"})
    List<TeamUserListRespDto> queryTeamUser(IdReqDto idReqDto);

    /**
     * 设置过期状态
     */
    @Select({"<script>" +
            "UPDATE tb_team " +
            " SET overdue = 1 " +
            " WHERE " +
            " NOW() > end_time;" +
            "</script>"})
    void queryIsOverdue();

    @Select({"<script>" +
            "SELECT " +
            "  c.id AS userId, " +
            "  temp.team_id AS teamId, " +
            "  temp.team_name AS teamName, " +
            "  c.username AS userName, " +
            "  c.img AS img, " +
            "  c.telephone AS telephone," +
            "  DATE_FORMAT( " +
            "    temp.gather_time, " +
            "    '%Y-%m-%d %h:%i' " +
            "  ) AS gatherTime, " +
            "  DATE_FORMAT( " +
            "    temp.end_time, " +
            "    '%Y-%m-%d %h:%i' " +
            "  ) AS endTime, " +
            "  temp.gathier_place AS gatherPlace " +
            "FROM " +
            "  ( " +
            "    SELECT " +
            "      a.* " +
            "    FROM " +
            "      tb_team AS a " +
            "    JOIN user_team AS b ON a.team_id = b.team_id " +
            "    WHERE " +
            "      b.user_id = #{userId} " +
            "  ) AS temp " +
            "JOIN tb_user AS c ON temp.user_id = c.id order by temp.team_id desc;" +
            "</script>"})
    List<TeamListQueryByIdRespDto> queryListById(IdReqDto idReqDto);


    @Select({"<script>" +
            "SELECT a.* FROM tb_team a,tb_type b WHERE a.type_id = b.type_id AND b.type_name LIKE '%#{keyWord}%'"
            + "</script>"})
    List<TeamEo> queryTeamByType(String keyWord);
}
