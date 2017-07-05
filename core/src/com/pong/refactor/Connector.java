package com.pong.refactor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Net;
import com.badlogic.gdx.maps.Map;
import com.badlogic.gdx.net.HttpRequestBuilder;

/**
 * Created by mischavandalen on 05/07/2017.
 */

public class Connector {
   // private Map<String, String> Parameters;
    private HttpRequestBuilder Requestbuilder;
    private Net.HttpRequest Httprequest;
    static String item;

    public Connector(){
        this.Requestbuilder = new HttpRequestBuilder();
        this.Httprequest = this.Requestbuilder.newRequest().method(Net.HttpMethods.POST).url("http://nekonekochan.org/pong_request.php").build();
        this.Httprequest.setHeader("Content-Type", "application/x-www-form-urlencoded");
        this.Httprequest.setTimeOut(6000);
    }
    public void Save_score(){
        this.Requestbuilder.content("AAA");
        this.Httprequest.reset();
    }
    public String Get_score() {
        Gdx.net.sendHttpRequest(this.Httprequest, new Net.HttpResponseListener() {
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
        this.Httprequest.reset();
        return item;
    }
}


}
