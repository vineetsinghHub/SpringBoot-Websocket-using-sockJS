package com.notification.dstplNotification.websocketSTOMP;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.Message;

@Service
public class NotificationService {

	@Autowired
	public  SimpMessagingTemplate messagingTemplate;
	
	public void sendInAppNotification(String destination, String message) {
        messagingTemplate.convertAndSend(destination, message);
    }

    public void sendPushNotification(String token, String title, String body) {
        Message pushMessage = Message.builder()
                .putData("title", title)
                .putData("body", body)
                .setToken(token)
                .build();

        try {
            String response = FirebaseMessaging.getInstance().send(pushMessage);
            System.out.println("Successfully sent message: " + response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
