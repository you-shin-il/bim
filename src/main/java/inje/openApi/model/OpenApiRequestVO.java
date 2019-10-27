package inje.openApi.model;

public class OpenApiRequestVO {
    /* 한 페이지 결과 수 */
    private int numOfRows = 10;

    /* 페이지 번호 */
    private int pageNo = 1;

    /* 오픈API 리턴 타입 */
    private final String TYPE = "json";

    /*
        조회구분
        1. 등록일시
        2. 통합계약번호
    */
    private int inqryDiv = 1;

    /*
        검색하고자하는 등록일시 범위 시작 'YYYYMMDDHHMM"
        조회구분이 1인 경우 필수
    */
    private String inqryBgnDt;

    /*
        검색하고자하는 등록일시 범위 시작 'YYYYMMDDHHMM"
        조회구분이 1인 경우 필수
    */
    private String inqryEndDt;

    /*
        검색하고자하는 통합계약번호
        조회구분이 2인 경우 필수
    */
    private int untyCntrctNo;

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

    public int getInqryDiv() {
        return inqryDiv;
    }

    public void setInqryDiv(int inqryDiv) {
        this.inqryDiv = inqryDiv;
    }

    public int getUntyCntrctNo() {
        return untyCntrctNo;
    }

    public void setUntyCntrctNo(int untyCntrctNo) {
        this.untyCntrctNo = untyCntrctNo;
    }

    public String getTYPE() {
        return TYPE;
    }

    public String getInqryBgnDt() {
        return inqryBgnDt;
    }

    public void setInqryBgnDt(String inqryBgnDt) {
        this.inqryBgnDt = inqryBgnDt;
    }

    public String getInqryEndDt() {
        return inqryEndDt;
    }

    public void setInqryEndDt(String inqryEndDt) {
        this.inqryEndDt = inqryEndDt;
    }
}