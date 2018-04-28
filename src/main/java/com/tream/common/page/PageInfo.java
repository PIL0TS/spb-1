package com.tream.common.page;

public class PageInfo {


    private int countPerPage;
    private int toPageNum;
    private int currentPageNum;
    private int maxPageNum;
    private int maxRowNum;


    public int getCountPerPage() {
        return countPerPage;
    }

    public void setCountPerPage(int countPerPage) {
        this.countPerPage = countPerPage;
    }

    public int getToPageNum() {
        return toPageNum;
    }

    public void setToPageNum(int toPageNum) {
        this.toPageNum = toPageNum;
    }

    public int getCurrentPageNum() {
        return currentPageNum;
    }

    public void setCurrentPageNum(int currentPageNum) {
        this.currentPageNum = currentPageNum;
    }

    public int getMaxPageNum() {
        return maxPageNum;
    }

    public void setMaxPageNum(int maxPageNum) {
        this.maxPageNum = maxPageNum;
    }

    public int getMaxRowNum() {
        return maxRowNum;
    }

    public void setMaxRowNum(int maxRowNum) {
        this.maxRowNum = maxRowNum;
    }


    @Override
    public String toString() {
        return "PageInfo{" +
                "countPerPage=" + countPerPage +
                ", toPageNum=" + toPageNum +
                ", currentPageNum=" + currentPageNum +
                ", maxPageNum=" + maxPageNum +
                ", maxRowNum=" + maxRowNum +
                '}';
    }
}
