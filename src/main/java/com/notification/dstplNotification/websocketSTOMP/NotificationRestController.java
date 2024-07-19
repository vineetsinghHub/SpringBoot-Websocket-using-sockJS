package com.notification.dstplNotification.websocketSTOMP;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Getter;
import lombok.Setter;

@RestController
@RequestMapping("/api/notifications")
public class NotificationRestController {

	 @Autowired
	    private NotificationService notificationService;

	    @PostMapping("/in-app")
	    public void sendInAppNotification(@RequestBody InAppNotificationRequest request) {
	        notificationService.sendInAppNotification(request.getDestination(), request.getMessage());
	    }

	    @PostMapping("/push")
	    public void sendPushNotification(@RequestBody PushNotificationRequest request) {
	        notificationService.sendPushNotification(request.getToken(), request.getTitle(), request.getBody());
	    }
}

@Getter
@Setter
class InAppNotificationRequest {
    private String destination;
    private String message;

    // Getters and setters
}

@Getter
@Setter
class PushNotificationRequest {
    private String token;
    private String title;
    private String body;

    // Getters and setters
}
