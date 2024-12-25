package ru.gb.springdemo.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gb.springdemo.model.Book;
import ru.gb.springdemo.service.BookService;

import java.util.NoSuchElementException;

@Slf4j
@RestController
@RequestMapping("/book")
public class BookController {
    private BookService service;

    @GetMapping("{id}")
    public ResponseEntity<Book> bookInfo(@PathVariable("id") long id) {
        final Book book;
        log.info( "Получен запрос на получение информации о книге: bookId = {}, ", id );
        try {
            book = service.bookInfo( id );
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status( HttpStatus.OK ).body( book );
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Boolean> deleteBook(@PathVariable("id") long id) {
        final Book book;
        log.info( "Получен запрос на удаление книги: bookId = {}, ", id );
        try {
            service.deleteBook(id);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status( HttpStatus.OK ).body( true );
    }

    @PutMapping("{name}")
    public ResponseEntity<Book> createBook(@PathVariable("name") String name){
        Book book;
        log.info( "Получен запрос на добавление книги: bookName = {}, ", name );
        try{
            book = service.createBook( name );
        } catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
        return ResponseEntity.status( HttpStatus.CREATED ).body( book );
    }
}


