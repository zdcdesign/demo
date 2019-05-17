package com.cy.demo.entity.activity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by zhoudachao on 2019/5/16.
 */
@Table(name = "tb_activity")
@ApiModel(value = "ActivityEo", discriminator = "活动表")
public class ActivityEo implements Serializable {

    @ApiModelProperty(value = "活动id", name = "activityId")
    @Column(name = "activity_id")
    private Integer activityId;

    @ApiModelProperty(value = "活动名称", name = "activityName")
    @Column(name = "activity_name")
    private String activityName;

    @ApiModelProperty(value = "活动负责人id", name = "leader")
    @Column(name = "leader")
    private Integer leader;

    @ApiModelProperty(value = "开始时间", name = "startTime")
    @Column(name = "start_time")
    private Date startTime;

    @ApiModelProperty(value = "结束时间", name = "endTime")
    @Column(name = "end_time")
    private Date endTime;

    @ApiModelProperty(value = "预计人数", name = "number")
    @Column(name = "number")
    private Integer number;

    @ApiModelProperty(value = "实际人数", name = "actualNumber")
    @Column(name = "actual_number")
    private Integer actualNumber;

    @ApiModelProperty(value = "活动地点", name = "activityPlace")
    @Column(name = "activity_place")
    private String activityPlace;

    @ApiModelProperty(value = "活动主题", name = "activityTheme")
    @Column(name = "activity_theme")
    private String activityTheme;

    @ApiModelProperty(value = "活动简介", name = "remark")
    @Column(name = "remark")
    private String remark;

    @ApiModelProperty(value = "视频地址", name = "video")
    @Column(name = "video")
    private String video;

    @ApiModelProperty(value = "海报图片地址", name = "logo")
    @Column(name = "logo")
    private String logo;

    @ApiModelProperty(value = "活动地点实景图1", name = "sceneImg1")
    @Column(name = "scene_img1")
    private String sceneImg1;

    @ApiModelProperty(value = "活动地点实景图2", name = "sceneImg2")
    @Column(name = "scene_img2")
    private String sceneImg2;

    @ApiModelProperty(value = "活动地点实景图3", name = "sceneImg3")
    @Column(name = "scene_img3")
    private String sceneImg3;

    @ApiModelProperty(value = "活动地点实景图4", name = "sceneImg4")
    @Column(name = "scene_img4")
    private String sceneImg4;

    @ApiModelProperty(value = "活动地点实景图5", name = "sceneImg5")
    @Column(name = "scene_img5")
    private String sceneImg5;

    @ApiModelProperty(value = "经度", name = "longitude")
    @Column(name = "longitude")
    private Double longitude;

    @ApiModelProperty(value = "纬度", name = "latitude")
    @Column(name = "latitude")
    private Double latitude;

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public Integer getLeader() {
        return leader;
    }

    public void setLeader(Integer leader) {
        this.leader = leader;
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

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getActualNumber() {
        return actualNumber;
    }

    public void setActualNumber(Integer actualNumber) {
        this.actualNumber = actualNumber;
    }

    public String getActivityPlace() {
        return activityPlace;
    }

    public void setActivityPlace(String activityPlace) {
        this.activityPlace = activityPlace;
    }

    public String getActivityTheme() {
        return activityTheme;
    }

    public void setActivityTheme(String activityTheme) {
        this.activityTheme = activityTheme;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getSceneImg1() {
        return sceneImg1;
    }

    public void setSceneImg1(String sceneImg1) {
        this.sceneImg1 = sceneImg1;
    }

    public String getSceneImg2() {
        return sceneImg2;
    }

    public void setSceneImg2(String sceneImg2) {
        this.sceneImg2 = sceneImg2;
    }

    public String getSceneImg3() {
        return sceneImg3;
    }

    public void setSceneImg3(String sceneImg3) {
        this.sceneImg3 = sceneImg3;
    }

    public String getSceneImg4() {
        return sceneImg4;
    }

    public void setSceneImg4(String sceneImg4) {
        this.sceneImg4 = sceneImg4;
    }

    public String getSceneImg5() {
        return sceneImg5;
    }

    public void setSceneImg5(String sceneImg5) {
        this.sceneImg5 = sceneImg5;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }
}
