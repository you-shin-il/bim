package inje.openApi.model;

import java.util.List;

public class OpenApiResponseBody {
    private List<OpenApiResponseItems> items;
    private int numOfRows;
    private int pageNo;
    private int totalCount;

    private int totalPage;
    private int startPage;
    private int endPage;

    public List<OpenApiResponseItems> getItems() {
        return items;
    }

    public int getNumOfRows() {
        return numOfRows;
    }

    public void setNumOfRows(int numOfRows) {
        this.numOfRows = numOfRows;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public void setItems(List<OpenApiResponseItems> items) {
        this.items = items;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getStartPage() {
        return startPage;
    }

    public void setStartPage(int startPage) {
        this.startPage = startPage;
    }

    public int getEndPage() {
        return endPage;
    }

    public void setEndPage(int endPage) {
        this.endPage = endPage;
    }

    public void setPaging() {
        totalPage = (totalCount/numOfRows);
        if(totalCount > numOfRows * 10) {
            totalPage++;
        }

        startPage  = (1 + ((pageNo-1) / 10) * 10);
        endPage = startPage + 10 - 1;
        if(endPage > totalPage) {
            endPage = totalPage;
        }
/*        int tempTotalCount = Integer.valueOf(totalCount);
        int tempNumOfRows = Integer.valueOf(numOfRows);
        int tempPageNo = Integer.valueOf(pageNo);

        totalPage = (tempTotalCount/tempNumOfRows);
        if(tempTotalCount > tempNumOfRows * 10) {
            totalPage++;
        }

        startPage  = (1 + ((tempPageNo-1) / 10) * 10);
        endPage = startPage + 10 - 1;
        if(endPage > totalPage) {
            endPage = totalPage;
        }*/
    }
}