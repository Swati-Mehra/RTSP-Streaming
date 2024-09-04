package com.example.demo.config;

import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class WebSocketHandler extends TextWebSocketHandler {

    @Override
    public void handleTextMessage(WebSocketSession session, org.springframework.web.socket.TextMessage message) throws Exception {
        // Handle incoming messages
        System.out.println("Received message: " + message.getPayload());
        // Send a response back to the client
        session.sendMessage(new org.springframework.web.socket.TextMessage("Message received"));
    }
}