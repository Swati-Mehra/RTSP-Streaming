package com.example.demo.config;

import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import org.springframework.web.socket.WebSocketHandler;

public class CustomWebSocketHandler extends TextWebSocketHandler {

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        // Handle incoming messages
        System.out.println("Received message: " + message.getPayload());
        // Send a response back to the client
        session.sendMessage(new TextMessage("Message received"));
    }
}