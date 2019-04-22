package com.cy.demo.dto.team;

import java.io.Serializable;

/**
 * 查询分页
 */
public class PageQueryReqDto implements Serializable {
    //关键字
    private String keyWord;
    //每页几条 默认为第一页10条
    private int pageSize = 10;
    //当前页
    private int pageNum = 1;

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }
}
