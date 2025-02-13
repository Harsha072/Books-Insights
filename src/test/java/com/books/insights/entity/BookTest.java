package com.books.insights.entity;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class BookTest {

    @Test
    public void testBookEntity() {
        Book book = new Book();
        book.setTitle("Spring in Action");
        book.setAuthor("Craig Walls");
        book.setIsbn("9781617294945");
        book.setPublicationYear(2020);
        book.setDescription("A comprehensive guide to Spring Boot.");

        assertThat(book.getTitle()).isEqualTo("Spring in Action");
        assertThat(book.getAuthor()).isEqualTo("Craig Walls");
        assertThat(book.getIsbn()).isEqualTo("9781617294945");
        assertThat(book.getPublicationYear()).isEqualTo(2020);
        assertThat(book.getDescription()).isEqualTo("A comprehensive guide to Spring Boot.");
    }
}