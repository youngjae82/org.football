/********************************
 *	프로젝트 : football
 *	패키지   : org.football.core.servlet.chat
 *	작성일   : 2016. 11. 16.
 *	프로젝트 : OPERA 
 *	작성자   : KYJ
 *******************************/
package org.football.core.servlet.chat;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.websocket.CloseReason;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.RemoteEndpoint.Basic;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;
import javax.websocket.server.ServerEndpoint;

/**
 * @author KYJ
 *
 */
@ServerEndpoint("/webChat")
public class ChatWebSocket {

	private static final Set<ChatWebSocket> connections = new CopyOnWriteArraySet<>();
	private Session conn;

	/**
	 * 
	 */
	public ChatWebSocket() {
	}

	/***
	 * 웹 소켓이 연결되면 호출되는 이벤트
	 */
	@OnOpen
	public void handleOpen(Session conn, EndpointConfig EndpointConfig) {
		System.out.println("client is now connected...");
		System.out.println(conn);
		this.conn = conn;
		connections.add(this);
		//		conn.addMessageHandler(String.class, new MessageHandler.Whole<String>() {
		//			@Override
		//			public void onMessage(String message) {
		//				System.out.println("Received message: " + message);
		//			}
		//		});

		//		conn.addMessageHandler(new MessageHandler.Whole<String>() {
		//			@Override
		//			public void onMessage(String message) {
		//				System.out.println("Received message: " + message);
		//			}
		//		});
	}

	/**
	 * 웹 소켓으로부터 메시지가 오면 호출되는 이벤트
	 * @param message
	 * @return
	 */
	@OnMessage
	public void handleMessage(Session session, String message) {
		System.out.println("receive from client : " + message);
		broadcast("send to client : " + message);
//		
//		if (message != null) {
//			WebSocketContainer container = session.getContainer();
//
//			Set<Session> openSessions = session.getOpenSessions();
//
//			session.getOpenSessions().forEach(s -> {
//				//				if (s.isOpen()) {
//				try {
//					Basic basicRemote = s.getBasicRemote();
//					String x = "send to client : " + message;
//					System.out.println(x);
//					basicRemote.sendText(x);
//
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//				//				}
//			});
//		}

	}

	/**
	 * 웹 소켓이 닫히면 호출되는 이벤트
	 */
	@OnClose
	public void handleClose(Session session, CloseReason reason) {
		System.out.println("client is now disconnected...");
		connections.remove(this);
	}

	/**
	 * 웹 소켓이 에러가 나면 호출되는 이벤트
	 * @param t
	 */
	@OnError
	public void handleError(Session session, Throwable t) {
		t.printStackTrace();
	}

	private static void broadcast(String msg) {
		for (ChatWebSocket client : connections) {
			try {
				synchronized (client) {
					client.conn.getBasicRemote().sendText(msg);
				}
			} catch (IOException e) {

				connections.remove(client);
				try {
					client.conn.close();
				} catch (IOException e1) {
					// Ignore
				}
				String message = String.format("* %s %s", "sample", "has been disconnected.");
				broadcast(message);
			}
		}
	}
}
