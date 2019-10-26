package inje.openApi.model;

public class OpenApiResponseVO {
    private OpenApiResponse response;

    public OpenApiResponse getResponse() {
        response.getBody().setPaging();
        return response;
    }

    public void setResponse(OpenApiResponse response) {
        this.response = response;
    }

}