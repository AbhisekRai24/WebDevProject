package com.example.resellcompany.controller;


import com.example.resellcompany.entity.Book;
import com.example.resellcompany.pojo.BookPojo;
import com.example.resellcompany.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.List;

@RestController
@RequestMapping("/bookings")

public class BookController {
    private BookService bookService;

    @GetMapping("get")
    public List<Book> getAllBookings() {
        return bookService.getAllBookings();
    }

    @GetMapping("getid/{id}")
    public Book getBookingById(@PathVariable Integer id) {
        return bookService.getBookingById(id);
    }

//
//    @PostMapping
//    public Book saveBooking(@RequestParam Integer userId, @RequestParam Integer bikeId, @RequestParam String dateTime) {
//        LocalDateTime bookDateTime = LocalDateTime.parse(dateTime);
//        Book bookPojo = new Book();
//        return bookService.saveBooking(bookPojo,userId, bikeId, bookDateTime);
//    }

    @PostMapping("/save")
    public ResponseEntity<String> createBooking(@RequestBody BookPojo bookPojo) {
        Integer userId = bookPojo.getUserId();
        Integer bikeId = bookPojo.getBikeId();
        LocalDateTime bookingDateTime = bookPojo.getBookingDateTime();



        if (bookingDateTime == null) {
            return ResponseEntity.badRequest().body("Invalid date-time format");
        }

        try {
            // Call the service to save the booking
            bookService.saveBooking(bookPojo, userId, bikeId, bookingDateTime);
            return ResponseEntity.ok("Booking successful");
        } catch (Exception e) {
            // Log the exception
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error saving booking");
        }
    }
//@PostMapping("/save")
//public ResponseEntity<String> createBooking(@RequestBody BookPojo bookPojo) {
//    Integer userId = bookPojo.getUserId();  // Assuming BookPojo has a userId field
//    Integer bikeId = bookPojo.getBikeId();  // Assuming BookPojo has a bikeId field
//    LocalDateTime bookDateTime = LocalDateTime.now();
//
////    LocalDateTime bookDateTime = LocalDateTime.parse(bookPojo.getbookDateTime());
//
//
//    bookService.saveBooking(bookPojo, userId, bikeId, bookDateTime);
//
//
//    return ResponseEntity.ok("Booking successful");
//}




    @PutMapping("/updateStatus/{id}")
    public ResponseEntity<Book> updateBookingStatus(@PathVariable Integer id,@RequestBody BookPojo bookPojo) {
        Book book = bookService.getBookingById(id);
        book.setStatus(true); // Update status to true
        Book updatedBooking = bookService.updateBooking(id, bookPojo);
        return ResponseEntity.ok(updatedBooking);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        bookService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("getbyuser/{userId}")
    public List<Book> getBookingsByUserId(@PathVariable Integer userId) {
        return bookService.getBookingsByUserId(userId);
    }
}
