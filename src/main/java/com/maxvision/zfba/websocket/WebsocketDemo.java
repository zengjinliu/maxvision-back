package com.maxvision.zfba.websocket;

import com.alibaba.fastjson.JSON;
import com.google.gson.reflect.TypeToken;
import com.maxvision.core.client.utils.CollectionUtils;
import com.maxvision.core.client.utils.SimpleJsonProcessor;
import com.maxvision.core.utils.Assert;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author minte
 */
@ServerEndpoint("/demo.ws")
public class WebsocketDemo {


    private static final Logger log = LogManager.getLogger(WebsocketDemo.class);
    /**当前session*/
    private Session session;
    /**连接的客户端*/
    private static final Map<String, WebsocketDemo> clients = new ConcurrentHashMap<>();

    @OnOpen
    public void onOpen(Session session) {
        //哪个询问室的哪个设备与服务端进行连接
        Map<String, List<String>> map = session.getRequestParameterMap();
        log.info("------------------->client key:{}",session.getId());
        clients.put(session.getId(),this);
    }

    @OnMessage
    public String onMessage(Session session, String message) {
        System.out.println(message);
        return null;
    }

    public void sendMessage(String message) {
        try {
            this.session.getBasicRemote().sendText(message);
        } catch (IOException e) {
            log.error(e);
        }
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        //log.error(throwable);
    }

    @OnClose
    public void onClose(Session session) {
        log.info("------------------->remove key:{}",session.getId());
        clients.remove(session.getId());
    }






    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }





}
