package com.example.resellcompany.service.impl;

import com.example.resellcompany.entity.Bike;
import com.example.resellcompany.entity.Book;
import com.example.resellcompany.entity.User;
import com.example.resellcompany.pojo.BookPojo;
import com.example.resellcompany.repository.BikeRepository;
import com.example.resellcompany.repository.BookRepository;
import com.example.resellcompany.repository.UserRepository;
import com.example.resellcompany.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final UserRepository userRepository;
    private BikeRepository bikeRepository;


    @Override
    public List<Book> getBookingsByUserId(Integer userId) {
        return bookRepository.findByUserId(userId);
    }

    @Override
    public Book updateBooking(Integer id, BookPojo bookPojo) {
        if (id == null) {
            throw new IllegalArgumentException("ID must not be null");
        }

        // Retrieve existing booking
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found for ID: " + id));

        // Validate and retrieve related entities
        User user = userRepository.findById(bookPojo.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found for ID: " + bookPojo.getUserId()));

        Bike bike = bikeRepository.findById(bookPojo.getBikeId())
                .orElseThrow(() -> new RuntimeException("Flight not found for ID: " + bookPojo.getBikeId()));

        // Update booking details
        book.setUser(user);
        book.setBike(bike);
        book.setBookingdate(LocalDate.from(bookPojo.getBookingDateTime()));
        book.setStatus(bookPojo.isStatus());


        return bookRepository.save(book);
    }

    @Override
    public List<Book> getAllBookings() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookingById(Integer id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found"));
    }

    @Override
    public Book saveBooking(BookPojo bookPojo, Integer userId, Integer bikeId, LocalDateTime bookDateTime) {
        Book book = new Book();

//        book.setBookingDate(bookPojo.getBookingDate());
        book.setUser(userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found")));
        book.setBike(bikeRepository.findById(bikeId).orElseThrow(() -> new RuntimeException("Bike not found")));
        book.setStatus(bookPojo.isStatus());
        book.setBookingdate(LocalDate.from(bookDateTime));

        return  bookRepository.save(book);



    }

    @Override
    public Optional<Book> findById(Integer id) {
        return bookRepository.findById(id);
    }

    @Override
    public void deleteById(Integer id) {
        bookRepository.deleteById(id);


    }
}
