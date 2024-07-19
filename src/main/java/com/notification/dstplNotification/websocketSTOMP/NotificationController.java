package com.notification.dstplNotification.websocketSTOMP;

import org.apache.tomcat.util.json.JSONFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import com.google.gson.JsonObject;

@Controller
public class NotificationController {

	  @Autowired
	    private SimpMessagingTemplate messagingTemplate;

//	  Mapped as /app/application
	    @MessageMapping("/application")
	    @SendTo("/all/messages")
	    public String sendToAll(String message) throws Exception {
	    	System.out.println("send to all"+ message);
	        return message;
	    }

//	    Mapped as /app/private
	    @MessageMapping("/private")
	    public void sendToSpecific(SpecificNotification notification) {
//	    	JsonObject json= new JsonObject();
//	    	json.addProperty("text", notification.getText());
//	    	json.addProperty("from", notification.getFrom());
	         messagingTemplate.convertAndSendToUser(notification.getTo(), "/specific",  notification.getFrom()+","+notification.getText());
	    }
	    
}
