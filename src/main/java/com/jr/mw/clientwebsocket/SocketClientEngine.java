package com.jr.mw.clientwebsocket;


import java.net.URISyntaxException;

public class SocketClientEngine{


	public static void main(String[] args) {
		try {
			WebClientEnum.CLIENT.initClient(new MsgWebSocketClient("ws://192.168.0.147:1993/webSocket"));
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
