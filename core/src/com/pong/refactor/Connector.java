package com.pong.refactor;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Net;
import com.badlogic.gdx.net.HttpParametersUtils;
import com.badlogic.gdx.net.HttpRequestBuilder;

import java.util.HashMap;

/**
 * Created by mischavandalen on 05/07/2017.
 */

public class Connector {
    private String Item;
    private Net.HttpRequest httpRequest;
    static String item;

    public void Set_Score(String Name, Integer Score){
        java.util.Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("name", Name);
        parameters.put("score", String.format("%s", Score));
        final Net.HttpRequest httpRequest = new Net.HttpRequest(Net.HttpMethods.POST);
        httpRequest.setHeader("Content-Type", "application/x-www-form-urlencoded");
        httpRequest.setHeader("Upgrade", "HTTP/1.1, HTTP/2.0, SHTTP/1.3, IRC/6.9, RTA/x11");
        httpRequest.setUrl("http://nekonekochan.org/pong_save.php");
        httpRequest.setContent(HttpParametersUtils.convertHttpParameters(parameters));
        httpRequest.setTimeOut(6000);

        Gdx.net.sendHttpRequest(httpRequest, new Net.HttpResponseListener() {
            @Override
            public void handleHttpResponse(Net.HttpResponse httpResponse) {}
            @Override
            public void failed(Throwable t) {}
            @Override
            public void cancelled() {}
        });
    }
    public String Get_Score(){
        HttpRequestBuilder requestBuilder = new HttpRequestBuilder();
        httpRequest = requestBuilder.newRequest().method(Net.HttpMethods.POST).url("http://nekonekochan.org/pong_request.php").build();
        httpRequest.setHeader("Content-Type", "application/x-www-form-urlencoded");

        httpRequest.setTimeOut(6000);

        Gdx.net.sendHttpRequest(httpRequest, new Net.HttpResponseListener() {
            @Override
                public void handleHttpResponse(Net.HttpResponse httpResponse) {
                item = httpResponse.getResultAsString();
            }
            @Override
            public void failed(Throwable t) {
                item = "failed to retrieve data";
            }
            @Override
            public void cancelled() {
                item = "cancelled conntection";
            }

        });
        httpRequest.reset();
        return Item;
    }

}