package com.books.insights.service;

import com.books.insights.entity.Book;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;


@Service
public class AiService {


@Value("${openai.key}")
String aiApiKey;

    @Value("${openai.url}")
    String aiApiUrl;
    public String generateAiInsights(Book book) {
        String prompt = "Generate a tagline for the book: " + book.getTitle() + " by " + book.getAuthor();

        // Construct headers
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + aiApiKey);
        headers.set("Content-Type", "application/json");

        // Construct request body
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("model", "gpt-4");  // Change to "gpt-3.5-turbo" if needed
        requestBody.put("messages", new Object[]{
                Map.of("role", "system", "content", "You are a book tagline generator."),
                Map.of("role", "user", "content", prompt)
        });

        // Create HttpEntity with headers
        HttpEntity<Map<String, Object>> requestEntity = new HttpEntity<>(requestBody, headers);

        // Send API request
        ResponseEntity<Map> responseEntity = restTemplate.exchange(aiApiUrl, HttpMethod.POST, requestEntity, Map.class);

        // Extract response
        if (responseEntity.getBody() != null && responseEntity.getBody().containsKey("choices")) {
            Map<String, Object> choice = (Map<String, Object>) ((Map[]) responseEntity.getBody().get("choices"))[0];
            Map<String, String> message = (Map<String, String>) choice.get("message");
            return message.get("content");
        }

        return "No response from AI";
    }

    private final RestTemplate restTemplate = new RestTemplate();


}