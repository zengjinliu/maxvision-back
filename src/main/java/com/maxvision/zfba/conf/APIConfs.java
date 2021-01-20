package com.maxvision.zfba.conf;

import java.net.HttpURLConnection;

import com.maxvision.core.client.net.RestAPIClient;
import com.maxvision.core.client.net.RestAPIConf;
import com.maxvision.core.client.utils.Base64;

public interface APIConfs {
    RestAPIConf dataType = new DataTypeConf();
    RestAPIConf timeOut = new TimeOutConf();
    AuthConf authConf = new AuthConf();
}

class TimeOutConf extends RestAPIConf {
    @Override
    public void beforeConnect(RestAPIClient arg0, HttpURLConnection arg1) {
    }

    @Override
    public void onInited(RestAPIClient api) {
        api.setAllowKeepAlive(false).setConnectTimeout(5 * 1000).setReadTimeout(5 * 1000);
    }

}

class DataTypeConf extends RestAPIConf {
    @Override
    public void onInited(final RestAPIClient api) {
        api.setAllowKeepAlive(false).setConnectTimeout(2 * 1000).setReadTimeout(2 * 1000);
        api.setHeader("Content-Type", "application/json");
    }

    @Override
    public void beforeConnect(RestAPIClient api, HttpURLConnection conn) {

    }
}

class AuthConf extends RestAPIConf{
    @Override
    public void onInited(RestAPIClient restAPIClient) {
        String username = "admin";
        String passWord = "max@";
        String auth = Base64.encode(username + ":" + passWord);
        restAPIClient.setHeader("Authorization", "Basic " + auth);
    }

    @Override
    public void beforeConnect(RestAPIClient restAPIClient, HttpURLConnection httpURLConnection) {

    }
}

