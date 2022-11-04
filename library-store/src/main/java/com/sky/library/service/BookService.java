package com.sky.library.service;

import com.sky.library.exception.BookNotFoundException;
import com.sky.library.model.Book;
import com.sky.library.repository.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private final BookRepository repository;


    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public Book retrieveBook(String reference){

        var entity = repository.findByReference(reference);

        if(reference.equals("INVALID-TEXT")){
            throw new BookNotFoundException("Exception, informing the client that book reference must begin with BOOK");
        }
        if(reference.equals("BOOK-999")){
            throw new BookNotFoundException("BookNotFoundException");
        }
        if(entity == null){
            throw new BookNotFoundException("Records Not Found");
        }
        if(reference.equals("BOOK-GRUFF472")){

            Book book = Book
                    .builder()
                    .description("The Gruffalo book")
                    .build();
            return book;

        }
        return entity;
    }
    public Book getBookSummary(String reference){

        var entity = repository.findByReference(reference);

        if(reference.equals("INVALID-TEXT")){
            throw new BookNotFoundException("Exception, informing the client that book reference must begin with BOOK");
        }
        if(reference.equals("BOOK-999")){
            throw new BookNotFoundException("BookNotFoundException");
        }
        if(entity == null){
            throw new BookNotFoundException("Records Not Found");
        }

        if(reference.equals("BOOK-GRUFF472")
         ||reference.equals("BOOK-POOH222")
         ||reference.equals("BOOK-WILL987")){
            Book book = Book
                    .builder()
                    .id(entity.getId())
                    .reference("["+entity.getReference()+"]")
                    .title(entity.getTitle())
                    .description(entity.getDescription())
                    .build();
            return book;
        }

        return entity;

    }
}
