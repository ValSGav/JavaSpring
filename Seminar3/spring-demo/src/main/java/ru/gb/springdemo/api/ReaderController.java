package ru.gb.springdemo.api;

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
public class ReaderController {
    @Autowired
    ReaderService service;
    @Autowired
    IssueRepository issueRepository;

    @GetMapping("{id}")
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
    public ResponseEntity<Reader> createReader(@RequestBody ReaderRequest request) {

        Reader reader;
        String name = request.getName();
        log.info( "Получен запрос на добавление читателя: ReaderName = {}, ", name );
        try {
            reader = service.createReader( name );
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
        return ResponseEntity.status( HttpStatus.CREATED ).body( reader );
    }

    @GetMapping("/{id}/issue")
    public ResponseEntity<Issue[]> getIssueOnReader(@PathVariable("id") long readerId) {
        try {
            Reader reader = service.ReaderInfo( readerId );
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status( HttpStatus.OK ).body(issueRepository.getIssuesByReaderId( readerId ));
    }
}
