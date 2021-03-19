package com.jr.mw.clientwebsocket;

import java.net.URI;
import java.net.URISyntaxException;

import org.java_websocket.WebSocket.READYSTATE;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class ClientTask extends WebSocketClient {

	private static final Logger logger =LoggerFactory.getLogger(ClientTask.class);

	public ClientTask(URI serverUri) {
		super(serverUri);
	}

	@Override
	public void onOpen(ServerHandshake arg0) {
		logger.info("------ MyWebSocket onOpen ------");
	}

	@Override
	public void onClose(int arg0, String arg1, boolean arg2) {
		logger.info("------ MyWebSocket onClose ------");
	}

	
	@Override
	public void onError(Exception ex) {
		// TODO Auto-generated method stub
		logger.info("-------- MyWebSocket onError--------");
	}
	
	@Override
	public void onMessage(String arg0) {
		logger.info("-------- 接收到服务端数据： " + arg0 + "--------");
	}

	public static void main(String[] args) throws URISyntaxException {

		URI uri = new URI("ws://192.168.0.147:1993/webSocket");

		// 此处的WebSocket服务端URI，上面服务端第2点有详细说明
		ClientTask myClient = new ClientTask(uri);
        //连接websocket服务端		
		 myClient.connect();
		 
		READYSTATE readyState = myClient.getReadyState();
		READYSTATE open = READYSTATE.OPEN;
		System.out.println(open.toString());
		System.out.println(readyState.toString());
		while (!myClient.getReadyState().equals(READYSTATE.OPEN)) {
	        logger.debug("连接中···请稍后");
	       
	     }
		// 往websocket服务端发送数据
		myClient.send("此为要发送的数据内容");
	}

	
	
	

}
