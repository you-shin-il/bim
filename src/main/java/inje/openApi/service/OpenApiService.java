package inje.openApi.service;

import com.google.gson.Gson;
import inje.openApi.model.OpenApiRequestVO;
import inje.openApi.model.OpenApiResponseVO;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@Service
@PropertySource("openApi.properties")
public class OpenApiService {
    @Value("${openApi.base.url}")
    private String baseUrl;
    @Value("${openApi.serviceKey}")
    private String serviceKey;

//    public OpenApiResponseVO get(OpenApiRequestVO openApiRequestVO, String serviceName) {
//        Gson gson = new Gson();
//        OpenApiResponseVO responseVO = null;
//
//        try(CloseableHttpClient httpClient = HttpClients.createDefault()) {
//            HttpGet httpGet = new HttpGet(getCntrctInfoListThng(openApiRequestVO, serviceName));
//            httpGet.setHeader("Content-Type", "application/json");
//
//            try(CloseableHttpResponse response = httpClient.execute(httpGet)) {
//                if(response != null && response.getStatusLine() != null) {
//                    /*System.out.println(EntityUtils.toString(response.getEntity()));*/
//                    responseVO = gson.fromJson(EntityUtils.toString(response.getEntity()), OpenApiResponseVO.class);
//                    responseVO.getResponse().getBody().setPaging();
//                }
//            }
//        }catch(IOException | URISyntaxException e) {
//            e.printStackTrace();
//        }
//
//        return responseVO;
//    }

    public OpenApiResponseVO getCntrctInfoListThng(OpenApiRequestVO openApiRequestVO) throws URISyntaxException, UnsupportedEncodingException {
        if(openApiRequestVO.getInqryDiv() == 1 && openApiRequestVO.getInqryBgnDt() == null) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("YYYYMMdd");
            Calendar cal = Calendar.getInstance();
            openApiRequestVO.setInqryEndDt(dateFormat.format(cal.getTime()));
            cal.add(Calendar.DAY_OF_MONTH, -7);
            openApiRequestVO.setInqryBgnDt(dateFormat.format(cal.getTime()));
        }

        URI uri = new URI(baseUrl + "getCntrctInfoListThng");
        URIBuilder builder = new URIBuilder(uri);
        builder.addParameter("inqryDiv", String.valueOf(openApiRequestVO.getInqryDiv()));
        builder.addParameter("inqryBgnDt", openApiRequestVO.getInqryBgnDt() + "0000");
        builder.addParameter("inqryEndDt", openApiRequestVO.getInqryEndDt() + "2359");
        builder.addParameter("untyCntrctNo", String.valueOf(openApiRequestVO.getUntyCntrctNo()));
        builder.addParameter("numOfRows", String.valueOf(openApiRequestVO.getNumOfRows()));
        builder.addParameter("pageNo", String.valueOf(openApiRequestVO.getPageNo()));
        builder.addParameter("type", String.valueOf(openApiRequestVO.getTYPE()));
        builder.addParameter("ServiceKey", serviceKey);
        System.out.println(java.net.URLDecoder.decode(builder.build().toString(), "UTF-8"));
        return get(java.net.URLDecoder.decode(builder.build().toString(), "UTF-8"));
    }

    public OpenApiResponseVO getCntrctInfoListThngDetail(OpenApiRequestVO openApiRequestVO) throws URISyntaxException, UnsupportedEncodingException {
        if(openApiRequestVO.getInqryDiv() == 1 && openApiRequestVO.getInqryBgnDt() == null) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("YYYYMMdd");
            Calendar cal = Calendar.getInstance();
            openApiRequestVO.setInqryEndDt(dateFormat.format(cal.getTime()));
            cal.add(Calendar.DAY_OF_MONTH, -7);
            openApiRequestVO.setInqryBgnDt(dateFormat.format(cal.getTime()));
        }

        URI uri = new URI(baseUrl + "getCntrctInfoListThngDetail");
        URIBuilder builder = new URIBuilder(uri);
        builder.addParameter("inqryDiv", String.valueOf(openApiRequestVO.getInqryDiv()));
        builder.addParameter("inqryBgnDt", openApiRequestVO.getInqryBgnDt() + "0000");
        builder.addParameter("inqryEndDt", openApiRequestVO.getInqryEndDt() + "2359");
        builder.addParameter("untyCntrctNo", String.valueOf(openApiRequestVO.getUntyCntrctNo()));
        builder.addParameter("numOfRows", String.valueOf(openApiRequestVO.getNumOfRows()));
        builder.addParameter("pageNo", String.valueOf(openApiRequestVO.getPageNo()));
        builder.addParameter("type", String.valueOf(openApiRequestVO.getTYPE()));
        builder.addParameter("ServiceKey", serviceKey);
        System.out.println(java.net.URLDecoder.decode(builder.build().toString(), "UTF-8"));
        return get(java.net.URLDecoder.decode(builder.build().toString(), "UTF-8"));
    }

    public OpenApiResponseVO getCntrctInfoListThngPPSSrch(OpenApiRequestVO openApiRequestVO) throws URISyntaxException, UnsupportedEncodingException {
        if(openApiRequestVO.getInqryDiv() == 1 && openApiRequestVO.getInqryBgnDt() == null) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("YYYYMMdd");
            Calendar cal = Calendar.getInstance();
            openApiRequestVO.setInqryEndDt(dateFormat.format(cal.getTime()));
            cal.add(Calendar.DAY_OF_MONTH, -7);
            openApiRequestVO.setInqryBgnDt(dateFormat.format(cal.getTime()));
        }

        URI uri = new URI(baseUrl + "getCntrctInfoListThngPPSSrch");
        URIBuilder builder = new URIBuilder(uri);
        builder.addParameter("inqryDiv", String.valueOf(openApiRequestVO.getInqryDiv()));
        builder.addParameter("inqryBgnDate", openApiRequestVO.getInqryBgnDt() + "0000");
        builder.addParameter("inqryEndDate", openApiRequestVO.getInqryEndDt() + "2359");
        builder.addParameter("untyCntrctNo", String.valueOf(openApiRequestVO.getUntyCntrctNo()));
        builder.addParameter("numOfRows", String.valueOf(openApiRequestVO.getNumOfRows()));
        builder.addParameter("pageNo", String.valueOf(openApiRequestVO.getPageNo()));
        builder.addParameter("type", String.valueOf(openApiRequestVO.getTYPE()));
        builder.addParameter("ServiceKey", serviceKey);
        System.out.println(java.net.URLDecoder.decode(builder.build().toString(), "UTF-8"));
        return get(java.net.URLDecoder.decode(builder.build().toString(), "UTF-8"));
    }

    private OpenApiResponseVO get(String url) {
        Gson gson = new Gson();
        OpenApiResponseVO responseVO = null;

        try(CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet httpGet = new HttpGet(url);
            httpGet.setHeader("Content-Type", "application/json");

            try(CloseableHttpResponse response = httpClient.execute(httpGet)) {
                if(response != null && response.getStatusLine() != null) {
                    /*System.out.println(EntityUtils.toString(response.getEntity()));*/
                    responseVO = gson.fromJson(EntityUtils.toString(response.getEntity()), OpenApiResponseVO.class);
                    responseVO.getResponse().getBody().setPaging();
                }
            }
        }catch(IOException e) {
            e.printStackTrace();
        }

        return responseVO;
    }
}