package com.example.resellcompany.repository;

import com.example.resellcompany.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {

    List<Book> findByUserId(Integer userId);
}
