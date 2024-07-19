package com.notification.dstplNotification.websocketSTOMP;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController {
	
	    @MessageMapping("/chat.sendMessage")
//	    @SendTo("/topic/public")
	    @SendTo("/all/public")
	    public ChatMessage sendMessage(@Payload ChatMessage chatMessage, SimpMessageHeaderAccessor headerAccessor) {
	        // Get the username of the sender and set it in the message
	        String username = (String) headerAccessor.getSessionAttributes().get("username");
	        System.out.println("Username: "+ username);
	        chatMessage.setSender(username);
	        return chatMessage;
	    }
}


