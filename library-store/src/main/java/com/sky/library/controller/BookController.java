package com.sky.library.controller;

import com.sky.library.model.Book;
import com.sky.library.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController {

    private final BookService service;


    public BookController(BookService service) {
        this.service = service;
    }

    @GetMapping("/reference/{reference}")
    public ResponseEntity<Book>retrieveBook(@PathVariable("reference") String reference){
        var book = service.retrieveBook(reference);

        return ResponseEntity.status(HttpStatus.OK).body(book);
    }

    @GetMapping("/{reference}")
    public ResponseEntity<Book>getBookSummary(@PathVariable("reference") String reference){
        var book = service.getBookSummary(reference);

        return ResponseEntity.status(HttpStatus.OK).body(book);
    }
}
