package com.jr.mw.server;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by 杨端端
 */
@Component
@ServerEndpoint("/webSocket")
public class WebSocket {
	private static final Logger log = LoggerFactory.getLogger(WebSocket.class);
    private Session session;

    private static CopyOnWriteArraySet<WebSocket> webSocketSet = new CopyOnWriteArraySet<WebSocket>();

    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
        webSocketSet.add(this);
        log.info("【websocket消息】有新的连接, 总数:{}", webSocketSet.size());
    }

    @OnClose
    public void onClose() {
        webSocketSet.remove(this);
        log.info("【websocket消息】连接断开, 总数:{}", webSocketSet.size());
    }

    @OnMessage
    public void onMessage(String message) {
        log.info("【websocket消息】收到客户端发来的消息:{}", message);
        sendMessage(message);
    }

    public void sendMessage(String message) {
        for (WebSocket webSocket: webSocketSet) {
            log.info("【websocket消息】广播消息, message={}", message);
            try {
                webSocket.session.getBasicRemote().sendText(message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
