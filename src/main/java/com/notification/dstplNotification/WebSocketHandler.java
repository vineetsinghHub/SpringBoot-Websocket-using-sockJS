package com.notification.dstplNotification;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class WebSocketHandler extends TextWebSocketHandler {

	  @Override
	    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
	        System.out.println("Connected: " + session.getId());
	    }

	    @Override
	    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
	        System.out.println("Received message: " + message.getPayload());
	        session.sendMessage(new TextMessage("Hello, " + message.getPayload() + "!"));
	    }

	    @Override
	    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
	        System.out.println("Disconnected: " + session.getId());
	    }
}
