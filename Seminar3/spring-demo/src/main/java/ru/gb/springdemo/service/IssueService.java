package ru.gb.springdemo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.gb.springdemo.api.IssueRequest;
import ru.gb.springdemo.model.Book;
import ru.gb.springdemo.model.Issue;
import ru.gb.springdemo.model.LogicalException;
import ru.gb.springdemo.repository.BookRepository;
import ru.gb.springdemo.repository.IssueRepository;
import ru.gb.springdemo.repository.ReaderRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class IssueService {

    // спринг это все заинжектит

    private final BookRepository bookRepository;
    private final ReaderRepository readerRepository;
    private final IssueRepository issueRepository;
    @Value("${application.max-allowed-books:1}")
    private int maxAllowedBook;

    public Issue[] getAllIssues() {
        return (Issue[]) issueRepository
                .findAll()
                .toArray();
    }

    public Issue issue(IssueRequest request) throws LogicalException {
        if (bookRepository.getReferenceById(request.getBookId()) == null) {
            throw new NoSuchElementException("Не найдена книга с идентификатором \"" + request.getBookId() + "\"");
        }
        if (readerRepository.getReferenceById(request.getReaderId()) == null) {
            throw new NoSuchElementException("Не найден читатель с идентификатором \"" + request.getReaderId() + "\"");
        }

        List<Issue> issueOnReader = issueRepository.getByReaderId(request.getReaderId());
        if (issueOnReader.size() >= maxAllowedBook) {
            StringBuilder exceptionCause = new StringBuilder().append("У читателя на руках книги:  ");
            for (Issue issue : issueOnReader) {
                exceptionCause
                        .append("\n")
                        .append(" книга ")
                        .append(bookRepository.getReferenceById(issue.getBookId()).getName());
            }
            throw new LogicalException(exceptionCause.toString());
        }
        Issue issue = new Issue(request.getBookId(), request.getReaderId());
        issueRepository.save(issue);
        return issue;
    }

    public Issue issueInfo(long id) {
        return issueRepository.getReferenceById(id);
    }

    public Issue issueReturnBook(IssueRequest issueRequest) throws ClassCastException {

        Issue[] issues = (Issue[]) issueRepository.getByReaderId(issueRequest
                        .getReaderId())
                .toArray();
        if (issues.length == 0)
            throw new NoSuchElementException("У читателя нет выданных книг.");
        for (Issue issue : issues) {
            if (issue.getBookId() == issueRequest.getBookId()) {
                issue.setReturnedAt(LocalDateTime.now());
                return issue;
            }
        }
        return null;
    }

    public List<Book> issueReturnBookByUserId(long id) {
        List<Book> books = new ArrayList<>();
        List<Issue> issues = issueRepository.getByReaderId(id);
        if (issues.size() == 0)
            throw new NoSuchElementException("У читателя нет выданных книг.");
        for (Issue issue : issues) {
            if (issue.getReturnedAt() == null) {
                books.add(bookRepository.getReferenceById(issue.getBookId()));
            }
        }
        return books;
    }
}
