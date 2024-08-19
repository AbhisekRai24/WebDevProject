package com.example.resellcompany.service;

import com.example.resellcompany.entity.Book;
import com.example.resellcompany.pojo.BookPojo;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface BookService {
    public List<Book> getBookingsByUserId(Integer userId);

    Book updateBooking(Integer id, BookPojo bookPojo);

    List<Book> getAllBookings();

    Book getBookingById(Integer id);


    Book saveBooking(BookPojo bookPojo, Integer userId, Integer bikeId, LocalDateTime bookDateTime);

    Optional<Book> findById(Integer id);

    void deleteById(Integer id);
}
