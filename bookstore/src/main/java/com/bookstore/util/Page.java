package com.bookstore.util;

/**
 * Created by never on 17-3-11.
 */
public class Page {
    private int totalNumber;
    private int currentPage;
    private int totalPage;
    private int pageNumber=5;
    private int startIndex;

    public int getTotalNumber() {
        return totalNumber;
    }

    public void setTotalNumber(int totalNumber) {
        this.totalNumber = totalNumber;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }
    public void count()
    {
        int totalPageTemp=totalNumber/pageNumber;
        int plus=(totalNumber%pageNumber)==0?0:1;
        totalPageTemp=totalPageTemp+plus;
        if(totalPageTemp<=0)
        {
            totalPageTemp=1;
        }
        totalPage=totalPageTemp;
        if(currentPage>totalPage)
        {
            currentPage=totalPage;
        }
        if(currentPage<1)
        {
            currentPage=1;
        }
        startIndex=(currentPage-1)*pageNumber;
    }
}
