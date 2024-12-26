package ru.gb.springdemo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.gb.springdemo.api.IssueRequest;
import ru.gb.springdemo.model.Issue;
import ru.gb.springdemo.model.LogicalException;
import ru.gb.springdemo.repository.BookRepository;
import ru.gb.springdemo.repository.IssueRepository;
import ru.gb.springdemo.repository.ReaderRepository;

import java.util.ArrayList;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class IssuerService {

    // спринг это все заинжектит
    private final BookRepository bookRepository;
    private final ReaderRepository readerRepository;
    private final IssueRepository issueRepository;
    @Value("${application.max-allowed-books:1}")
    private int maxAllowedBook;

    public Issue issue(IssueRequest request) throws LogicalException {
        if ( bookRepository.getBookById( request.getBookId() ) == null ) {
            throw new NoSuchElementException( "Не найдена книга с идентификатором \"" + request.getBookId() + "\"" );
        }
        if ( readerRepository.getReaderById( request.getReaderId() ) == null ) {
            throw new NoSuchElementException( "Не найден читатель с идентификатором \"" + request.getReaderId() + "\"" );
        }

        Issue[] issueOnReader = issueRepository.getIssuesByReaderId( request.getReaderId() );
        if ( issueOnReader.length >= maxAllowedBook ) {
            StringBuilder exceptionCause = new StringBuilder().append( "У читателя на руках книги:  " );
            for (Issue issue : issueOnReader) {
                exceptionCause
                        .append( "\n" )
                        .append( " книга " )
                        .append( bookRepository.getBookById( issue.getBookId() ).getName() );
            }
            throw new LogicalException( exceptionCause.toString() );
        }
        Issue issue = new Issue( request.getBookId(), request.getReaderId() );
        issueRepository.save( issue );
        return issue;
    }

    public Issue issueInfo(long id) {
        return issueRepository.getIssueByID( id );
    }
}
