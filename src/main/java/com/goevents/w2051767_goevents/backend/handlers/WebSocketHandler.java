package com.goevents.w2051767_goevents.backend.handlers;

import com.fasterxml.jackson.databind.ObjectMapper;
//import com.websocket.server.model.Stock;
import com.goevents.w2051767_goevents.backend.components.SystemConfigComponent;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

public class WebSocketHandler extends TextWebSocketHandler {
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final List<WebSocketSession> sessionSockets = new CopyOnWriteArrayList<>();

    Random newRandom = new Random();

    @Override
    public void afterConnectionEstablished(WebSocketSession sessionSocket) throws Exception {
        //int randomValue = 0
        try {

        while (true) {
            //randomValue = newRandom.nextInt(100);


            //Stock newStock = new Stock(randomValue);

            TextMessage newMessage = new TextMessage(objectMapper.writeValueAsString(SystemConfigComponent.getTotalTicketPool()));
            sessionSocket.sendMessage(newMessage);
            Thread.sleep(1000);


        }
    }
        catch (InterruptedException e){
            System.out.println("Ended the thread");
        }
        //sessionSockets.add(sessionSocket);


    }

}
