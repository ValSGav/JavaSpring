package ru.gb.springdemo.service;

import jakarta.annotation.PostConstruct;
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
        try {
            Book book = bookRepository.getReferenceById(id);
            return book;
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Не найдена книга с идентификатором \"" + id + "\"");
        }
    }

    public List<Book> getAllBook() {
        return bookRepository.findAll();
    }

    public void deleteBook(long id) {
        try {
            Book book = bookRepository.getReferenceById(id);
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Не найдена книга с идентификатором \"" + id + "\"");
        }
        bookRepository.deleteById(id);
    }

    public Book createBook(String name) {
        return bookRepository.save(new Book(name));
    }

    @PostConstruct
    void createSomeBooks(){
        bookRepository.save(new Book("Война и мир"));
        bookRepository.save(new Book("Полночный пир"));
        bookRepository.save(new Book("Надкушенный зефир"));
    }
}
