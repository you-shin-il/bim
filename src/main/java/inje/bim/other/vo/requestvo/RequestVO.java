package inje.bim.other.vo.requestvo;

import inje.bim.other.vo.requestvo.request.Request;

public class RequestVO {
    private String token;
    private Request request;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }
}