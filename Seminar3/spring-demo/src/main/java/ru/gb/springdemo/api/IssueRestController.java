package ru.gb.springdemo.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gb.springdemo.model.Issue;
import ru.gb.springdemo.model.LogicalException;
import ru.gb.springdemo.service.IssueService;

import java.util.NoSuchElementException;

@Slf4j
@RestController
@RequestMapping("/issue")
@Tag(name = "Issues")
public class IssueRestController {

    @Autowired
    private IssueService service;

    @PostMapping
    @Operation(summary = "issue book", description = "Выдать книгу, в теле запроса id читателя, id  книги")
    public ResponseEntity<Issue> issueBook(@RequestBody IssueRequest request) {
        log.info( "Получен запрос на выдачу: readerId = {}, bookId = {}", request.getReaderId(), request.getBookId() );

        final Issue issue;
        try {
            issue = service.issue( request );
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        } catch (LogicalException e){
            log.info( e.getMessage() );
            return ResponseEntity.status( HttpStatus.CONFLICT ).build();
        }

        return ResponseEntity.status( HttpStatus.CREATED ).body( issue );
    }

    @GetMapping("{id}")
    @Operation(summary = "get issue", description = "Выгружает информацию о выданной книге, по id книги")
    public ResponseEntity<Issue> issueInfo(@PathVariable("id") long id) {
        final Issue issue;
        log.info( "Получен запрос на получение информации о выдаче книги с ИД: issueId = {}, ", id );
        try {
            issue = service.issueInfo( id );
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status( HttpStatus.OK ).body( issue );
    }

    @PutMapping()
    @Operation(summary = "return book", description = "Возврат книги")
    public ResponseEntity<Issue> returnBook (@RequestBody IssueRequest request) {
        log.info( "Получен запрос на возврат: readerId = {}, bookId = {}", request.getReaderId(), request.getBookId() );

        final Issue issue;

        issue = service.issueReturnBook( request );

        if (issue == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.status( HttpStatus.OK ).body( issue );
    }

}
