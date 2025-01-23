package ru.gb.springdemo.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gb.springdemo.model.Issue;
import ru.gb.springdemo.model.Reader;
import ru.gb.springdemo.repository.IssueRepository;
import ru.gb.springdemo.service.ReaderService;


import java.util.NoSuchElementException;

@Slf4j
@RestController
@RequestMapping("/reader")
@Tag(name = "Reader")
public class ReaderRestController {
    @Autowired
    ReaderService service;
    @Autowired
    IssueRepository issueRepository;

    @GetMapping("{id}")
    @Operation(summary = "get reader", description = "Выгружает читателя по Id")
    public ResponseEntity<Reader> readerInfo(@PathVariable("id") long id) {
        final Reader reader;
        log.info( "Получен запрос на получение информации о читателе: ReaderId = {}, ", id );
        try {
            reader = service.ReaderInfo( id );
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status( HttpStatus.OK ).body( reader );
    }

    @DeleteMapping("{id}")
    @Operation(summary = "delete reader", description = "Удаляет читателя по Id")
    public ResponseEntity<Boolean> deleteReader(@PathVariable("id") long id) {
        final Reader reader;
        log.info( "Получен запрос на удаление читателя: ReaderId = {}, ", id );
        try {
            service.deleteReader( id );
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status( HttpStatus.OK ).build();
    }

    @PutMapping("/add")
    @Operation(summary = "add reader", description = "Добавляет читателя")
    public ResponseEntity<Reader> createReader(@RequestBody ReaderRequest request) {

        String name = request.getName();
        log.info( "Получен запрос на добавление читателя: ReaderName = {}, ", name );
        try {
            return ResponseEntity.status( HttpStatus.CREATED ).body( service.createReader( name ) );

        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }

    }

    @GetMapping("/{id}/issue")
    @Operation(summary = "get issuer by id reader", description = "Выгружает все выданные читателю книги")
    public ResponseEntity<Issue[]> getIssueOnReader(@PathVariable("id") long readerId) {
        try {
            Reader reader = service.ReaderInfo( readerId );
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status( HttpStatus.OK ).body((Issue[]) issueRepository.getByReaderId( readerId ).toArray());
    }
}
