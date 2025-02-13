package com.books.insights.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
@Entity
public class Book {

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setPublicationYear(Integer publicationYear) {
        this.publicationYear = publicationYear;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Title is required")
    private String title;

    @NotBlank(message = "Auth/or is required")
    private String author;

    @NotBlank(message = "ISBN is required")
    private String isbn;

    @NotNull(message = "Publication year is required")
    @Min(value = 1000, message = "Publication year must be valid")
    @Max(value = 9999, message = "Publication year must be valid")
    private Integer publicationYear;

    private String description;

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public Integer getPublicationYear() {
        return publicationYear;
    }

    public String getDescription() {
        return description;
    }
}