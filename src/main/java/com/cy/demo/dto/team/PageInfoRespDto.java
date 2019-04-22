package com.cy.demo.dto.team;

import java.io.Serializable;
import java.util.List;

/**
 * 队伍查询分页
 */
public class PageInfoRespDto implements Serializable {

    //总页数
    private Integer totalPage;
    // 总条数
    private Integer total;

    //分页查询出的集合
    private List<TeamListDto> pageList;

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<TeamListDto> getPageList() {
        return pageList;
    }

    public void setPageList(List<TeamListDto> pageList) {
        this.pageList = pageList;
    }
}
