package com.cy.demo.entity.invite;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by zhoudachao on 2019/5/17.
 */
@Table(name = "tb_invite")
@ApiModel(value = "InviteEo", discriminator = "邀请表")
public class InviteEo {

    @ApiModelProperty(value = "发送者id", name = "sendId")
    @Column(name = "send_id")
    private Integer sendId;

    @ApiModelProperty(value = "被邀请者id", name = "inviteId")
    @Column(name = "invite_id")
    private Integer inviteId;

    @ApiModelProperty(value = "队伍id", name = "teamId")
    @Column(name = "team_id")
    private Integer teamId;

    @ApiModelProperty(value = "邀请创建时间", name = "inviteTime")
    @Column(name = "invite_time")
    private Date inviteTime;
    //0:未接受 ，1:已接受 ,2已拒绝
    @ApiModelProperty(value = "接受状态", name = "state")
    @Column(name = "state")
    private Integer state;
}
