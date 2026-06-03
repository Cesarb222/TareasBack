package com.example.projects.ctask.configuration.WebSocket;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfiguration implements WebSocketMessageBrokerConfigurer {

    //El broker nos permite la configuración entre el cliente y el servidor
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/topic");
        //Pack de destino de los mensajes
        registry.setApplicationDestinationPrefixes("/app");
    }

    //Permite registrar los endpoints
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/chat-socket")
            .setAllowedOrigins("http://localhost:4200")
            .withSockJS();
            //Libreria del socket
    }

}
