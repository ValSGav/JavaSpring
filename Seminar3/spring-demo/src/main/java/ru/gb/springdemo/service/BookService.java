package ru.gb.springdemo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.springdemo.api.IssueRequest;
import ru.gb.springdemo.model.Book;
import ru.gb.springdemo.repository.BookRepository;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public Book bookInfo(long id) {
        if ( bookRepository.getById( id ) == null ) {
            throw new NoSuchElementException( "Не найдена книга с идентификатором \"" + id + "\"" );
        }
        return bookRepository.getById( id );
    }

    public Book[] getAllBook() {
        return (Book[]) bookRepository.findAll().stream().toArray();
    }

    public void deleteBook(long id) {
        if ( bookRepository.getById( id ) == null ) {
            throw new NoSuchElementException( "Не найдена книга с идентификатором \"" + id + "\"" );
        }
        bookRepository.deleteById( id );

    }

    public Book createBook(String name) {
        return bookRepository.save( new Book( name ) );
    }
}
