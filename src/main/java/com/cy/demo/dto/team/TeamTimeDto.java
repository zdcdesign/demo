package com.cy.demo.dto.team;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Date;

/**
 * 查询队伍中的三个时间
 */
public class TeamTimeDto implements Serializable {

    @ApiModelProperty(value = "集合时间", name = "gatherTime")
    private Date gatherTime;

    @ApiModelProperty(value = "开始时间", name = "startTime")
    private Date startTime;

    @ApiModelProperty(value = "结束时间", name = "endTime")
    private Date endTime;

    public Date getGatherTime() {
        return gatherTime;
    }

    public void setGatherTime(Date gatherTime) {
        this.gatherTime = gatherTime;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
