package com.books.insights;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.books.insights")
public class BooksInsightsApplication {

	public static void main(String[] args) {
		SpringApplication.run(BooksInsightsApplication.class, args);
	}

}
