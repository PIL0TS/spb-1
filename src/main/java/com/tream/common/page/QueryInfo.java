package com.tream.common.page;

public class QueryInfo<T> {
    private T entity;
    private PageInfo pageInfo;


    public T getEntity() {
        return entity;
    }

    public void setEntity(T entity) {
        this.entity = entity;
    }

    public PageInfo getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
    }


    @Override
    public String toString() {
        return "QueryInfo{" +
                "entity=" + entity +
                ", pageInfo=" + pageInfo +
                '}';
    }
}
