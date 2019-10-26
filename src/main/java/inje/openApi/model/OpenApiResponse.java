package inje.openApi.model;

public class OpenApiResponse {
    private OpenApiResponseHeader header;
    private OpenApiResponseBody body;

    public OpenApiResponseHeader getHeader() {
        return header;
    }

    public void setHeader(OpenApiResponseHeader header) {
        this.header = header;
    }

    public OpenApiResponseBody getBody() {
        return body;
    }

    public void setBody(OpenApiResponseBody body) {
        this.body = body;
    }
}
