package com.books.insights.repository;


import com.books.insights.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByTitleContaining(String title);
    List<Book> findByAuthorContaining(String author);
    List<Book> findByTitleContainingAndAuthorContaining(String title, String author);
}