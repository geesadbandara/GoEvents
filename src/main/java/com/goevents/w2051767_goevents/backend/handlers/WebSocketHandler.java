package com.goevents.w2051767_goevents.backend.handlers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.goevents.w2051767_goevents.backend.components.ResponseBodyComponent;
import com.goevents.w2051767_goevents.backend.components.SystemConfigComponent;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;



public class WebSocketHandler extends TextWebSocketHandler {
    private final ObjectMapper objectMapper = new ObjectMapper();
    private  TextMessage newMessage;
    private ResponseBodyComponent newResponseBody;


    @Override
    public void afterConnectionEstablished(WebSocketSession sessionSocket) throws Exception {
        try {

        while (true) {

            newResponseBody = new ResponseBodyComponent(SystemConfigComponent.getTotalTicketPool(),SystemConfigComponent.getSystemStatus());

            newMessage = new TextMessage(objectMapper.writeValueAsString(newResponseBody));
            sessionSocket.sendMessage(newMessage);
            Thread.sleep(500);


        }
    }
        catch (InterruptedException e){
            System.out.println("Ended the thread");
        }


    }

}
