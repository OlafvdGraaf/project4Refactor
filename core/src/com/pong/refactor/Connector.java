package com.pong.refactor;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Net;
import com.badlogic.gdx.net.HttpRequestBuilder;

/**
 * Created by mischavandalen on 05/07/2017.
 */

public class Connector {
    private String Item;
    private Net.HttpRequest httpRequest;
    private Net.HttpResponseListener HttpResponseListener;
    static String item;

    public Connector(){

    }
    public String Get_Score(){
//        java.util.Map<String, String> parameters = new HashMap<String, String>();
//        parameters.put("username", username);
//        parameters.put("password", password);

        HttpRequestBuilder requestBuilder = new HttpRequestBuilder();
        httpRequest = requestBuilder.newRequest().method(Net.HttpMethods.POST).url("http://nekonekochan.org/pong_request.php").build();
        httpRequest.setHeader("Content-Type", "application/x-www-form-urlencoded");

        httpRequest.setTimeOut(6000);

        Gdx.net.sendHttpRequest(httpRequest, new HttpResponseListener() {
            @Override
            public void handleHttpResponse(Net.HttpResponse httpResponse) {
                item = httpResponse.getResultAsString();
            }

            @Override
            public void failed(Throwable t) {
                item = "failed";
            }

            @Override
            public void cancelled() {
                item = "canceled";
            }
        });

        httpRequest.reset();
        return Item;
    }

}