package com.notification.dstplNotification.websocketSTOMP;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketSTOMP implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
    	System.out.println("MessageBrokerRegistry: "+ config);
        config.enableSimpleBroker("/all","/specific");
        config.setApplicationDestinationPrefixes("/app");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
    	System.out.println("registerStompEndpoints"+ registry);
    	registry.addEndpoint("/gs").setAllowedOriginPatterns("*");
        registry.addEndpoint("/gs").setAllowedOriginPatterns("*").withSockJS();
    }
}
