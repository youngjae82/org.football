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

import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.football.core.util.HTMLFilter;

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
		this.conn = conn;
		connections.add(this);
	}

	/**
	 * 웹 소켓으로부터 메시지가 오면 호출되는 이벤트
	 * 
	 * @param message
	 * @return
	 */
	@OnMessage
	public void handleMessage(Session session, String message) {
		String filteredMessage = String.format("%s: %s", "", HTMLFilter.filter(message.toString()));
		broadcast(filteredMessage);
		//
		// if (message != null) {
		// WebSocketContainer container = session.getContainer();
		//
		// Set<Session> openSessions = session.getOpenSessions();
		//
		// session.getOpenSessions().forEach(s -> {
		// // if (s.isOpen()) {
		// try {
		// Basic basicRemote = s.getBasicRemote();
		// String x = "send to client : " + message;
		// System.out.println(x);
		// basicRemote.sendText(x);
		//
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
		// // }
		// });
		// }

	}

	/**
	 * 웹 소켓이 닫히면 호출되는 이벤트
	 */
	@OnClose
	public void handleClose() {
		connections.remove(this);

		String message = "client is now disconnected...";
		broadcast(message);

	}

	/**
	 * 웹 소켓이 에러가 나면 호출되는 이벤트
	 * 
	 * @param t
	 */
	@OnError
	public void onError(Throwable t) {
		connections.remove(this);
		t.printStackTrace();
	}

	private static void broadcast(String msg) {
		for (ChatWebSocket client : connections) {
			try {
				synchronized (client) {
					Session conn = client.conn;
					if (conn.isOpen())
						conn.getBasicRemote().sendText(msg);
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
