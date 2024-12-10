package com.goevents.w2051767_goevents.backend.configurations;

import com.goevents.w2051767_goevents.backend.handlers.WebSocketHandler;
import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer{
    @Bean
    public WebSocketHandler tradeWebSocketHandler(){
        return new WebSocketHandler() {
        };//calling the socketHandler
    }

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(tradeWebSocketHandler(),"/totalTicket").setAllowedOrigins("*");
        registry.addHandler(tradeWebSocketHandler(),"/getLog").setAllowedOrigins("*");
    }
}
