package com.spring.ollama.spring_ai_ollama.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final ChatClient chatClient;

    public EmailService(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    public String generateEmail(String topic) {

        String prompt = """
            Write a professional business email about:
            %s
            Keep tone polite and corporate.
            """.formatted(topic);

        return chatClient.prompt()
                .user(prompt)
                .call()
                .content();
    }
}