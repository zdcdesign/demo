package com.cy.demo.entity.power;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by zhoudachao on 2019/4/23.
 */
@Table(name="tb_role")
@ApiModel(value = "RoleEo",description = "角色表")
public class RoleEo implements Serializable{

    @ApiModelProperty(value = "id",name = "id")
    @Column(name = "id")
    private Integer id;

    @ApiModelProperty(value = "角色名称",name = "name")
    @Column(name="name")
    private String name;

    @ApiModelProperty(value = "角色代码",name = "code")
    @Column(name="code")
    private String code;

    @ApiModelProperty(value = "角色描述",name = "description")
    @Column(name="description")
    private String description;


    @ApiModelProperty(value = "备注")
    @Column(name="remark")
    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
