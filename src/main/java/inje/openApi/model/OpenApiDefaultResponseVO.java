package inje.openApi.model;

public class OpenApiDefaultResponseVO {
    /* 결과코드 */
    private int resultCode;
    /* 결과메세지 */
    private String resultMsg;
    /* 한 페이지 결과 수 */
    private int numOfRows = 10;
    /* 페이지 번호 */
    private int pageNo;
    /* 전체 결과 수 */
    private int totalCount;

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
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
}