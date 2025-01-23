package ru.gb.springdemo.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gb.springdemo.model.Book;
import ru.gb.springdemo.service.BookService;

import java.util.NoSuchElementException;

@Slf4j
@RestController
@RequestMapping("/book")
@Tag(name = "Books")
public class BookRestController {
    @Autowired
    private BookService service;

    @GetMapping("{id}")
    @Operation(summary = "get book", description = "Выгружает книгу по Id")
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

    @Operation(summary = "delete book", description = "Удаляет книгу по Id")
    @DeleteMapping("{id}")
    public ResponseEntity<Boolean> deleteBook(@PathVariable("id") long id) {
        final Book book;
        log.info( "Получен запрос на удаление книги: bookId = {}, ", id );
        try {
            service.deleteBook(id);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status( HttpStatus.OK ).build();
    }

    @Operation(summary = "add book", description = "Добавляет книгу, в теле запроса имя книги")
    @PutMapping("/add")
    public ResponseEntity<Book> createBook(@RequestBody BookRequest request){

        Book book;
        String name = request.getName();
        log.info( "Получен запрос на добавление книги: bookName = {}, ", name );
        try{
            book = service.createBook( name );
        } catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
        return ResponseEntity.status( HttpStatus.CREATED ).body( book );
    }
}


