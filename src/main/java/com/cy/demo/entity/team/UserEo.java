package com.cy.demo.entity.team;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Table(name = "tb_user")
@ApiModel(value = "UserEo", discriminator = "用户表")
public class UserEo implements Serializable {

    @ApiModelProperty(value = "id", name = "id")
    @Column(name = "id")
    private Integer id;

    @ApiModelProperty(value = "用户名", name = "userName")
    @Column(name = "username")
    private String userName;

    @ApiModelProperty(value = "密码", name = "password")
    @Column(name = "password")
    private String password;

    @ApiModelProperty(value = "电话", name = "telephone")
    @Column(name = "telephone")
    private String telephone;

    @ApiModelProperty(value = "创建时间", name = "created")
    @Column(name = "created")
    private Date created;

    @ApiModelProperty(value = "更新时间", name = "updated")
    @Column(name = "updated")
    private Date updated;

    @ApiModelProperty(value = "跟新人", name = "updateUser")
    @Column(name = "update_user")
    private String updateUser;

    @ApiModelProperty(value = "备注", name = "remark")
    @Column(name = "remark")
    private String remark;

    @ApiModelProperty(value = "姓名", name = "name")
    @Column(name = "name")
    private String name;

    @ApiModelProperty(value = "学校", name = "school")
    @Column(name = "school")
    private String school;

    @ApiModelProperty(value = "学院", name = "academy")
    @Column(name = "academy")
    private String academy;

    @ApiModelProperty(value = "专业", name = "major")
    @Column(name = "major")
    private String major;

    @ApiModelProperty(value = "学号", name = "studentId")
    @Column(name = "student_id")
    private String studentId;

    @ApiModelProperty(value = "经度", name = "longitude")
    @Column(name = "longitude")
    private Double longitude;

    @ApiModelProperty(value = "纬度", name = "latitude")
    @Column(name = "latitude")
    private Double latitude;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getAcademy() {
        return academy;
    }

    public void setAcademy(String academy) {
        this.academy = academy;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
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
