package com.djz.self.vo;

public class Tablepar {

    private int pageNum = 1;//页码
    private int pageSize = 20;//数量

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "Tablepar{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                '}';
    }

}