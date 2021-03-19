package com.jr.mw.clientwebsocket;

import org.java_websocket.WebSocket.READYSTATE;

public enum WebClientEnum {
 
	CLIENT;
	
	private static MsgWebSocketClient socketClient = null;
	
	public static void initClient(MsgWebSocketClient client) {
		socketClient = client;
		boolean falg=socketClient.equals("null")||socketClient==null||socketClient.equals("");
		
		
		if(!falg) {
			READYSTATE readyState = socketClient.getReadyState();
			while (!socketClient.getReadyState().equals(READYSTATE.OPEN)) {
		       System.out.println("连接中···请稍后");
		     }
			socketClient.connect();
			socketClient.send("测试websocket。。。");
		}
		boolean flag = true;
		int i=1000;
		while(flag) {
			socketClient.send("测试websocket。。。"+(i--));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(i == 0) {
				flag = false;
			}
		}
	}
	
}

