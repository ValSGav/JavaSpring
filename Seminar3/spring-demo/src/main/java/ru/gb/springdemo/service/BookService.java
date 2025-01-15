package ru.gb.springdemo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.springdemo.model.Book;
import ru.gb.springdemo.repository.BookRepository;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public Book bookInfo(long id) {
        if ( bookRepository.getBookById( id ) == null ) {
            throw new NoSuchElementException( "Не найдена книга с идентификатором \"" + id + "\"" );
        }
        return bookRepository.getBookById( id );
    }

    public List<Book> getAllBook(){
        return bookRepository.getAllBook();
    }

    public void deleteBook(long id) {
        if ( bookRepository.getBookById( id ) == null ) {
            throw new NoSuchElementException( "Не найдена книга с идентификатором \"" + id + "\"" );
        }
        bookRepository.deleteBookById( id );

    }

    public Book createBook(String name) {
        return bookRepository.createBook( name );
    }
}
