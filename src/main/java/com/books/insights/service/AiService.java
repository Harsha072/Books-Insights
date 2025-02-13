package com.books.insights.service;

import com.books.insights.entity.Book;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AiService {

    @Value("${ai.api.url}")
    private String aiApiUrl;

    @Value("${ai.api.key}")
    private String aiApiKey;

    private final RestTemplate restTemplate = new RestTemplate();

    public  String generateAiInsights(Book book) {
        String prompt = "Generate a tagline for the book: " + book.getTitle() + " by " + book.getAuthor();
        // Call the AI API (example using a placeholder URL)
        return restTemplate.postForObject(aiApiUrl, prompt, String.class);
    }
}