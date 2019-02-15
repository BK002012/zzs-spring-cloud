package com.ljj.springcloud.pojo.dto;

public class PageDTO {
    private int pageIndex;
    private int pageSize;
    private int offset;

    @Override
    public String toString() {
        return "PageDTO{" +
                "pageIndex=" + pageIndex +
                ", pageSize=" + pageSize +
                ", offset=" + offset +
                '}';
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }
}
