package ru.gb.springdemo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.springdemo.model.Book;
import ru.gb.springdemo.model.Reader;
import ru.gb.springdemo.repository.ReaderRepository;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ReaderService {

    private final ReaderRepository readerRepository;

    public void deleteReader(long id) {
        if ( readerRepository.getReaderById( id ) == null ) {
            throw new NoSuchElementException( "Не найдена книга с идентификатором \"" + id + "\"" );
        }
        readerRepository.deleteReaderById( id );

    }

    public Reader createReader(String name) {
        return readerRepository.creatReader( name );
    }

    public Reader ReaderInfo(long id) {
        if ( readerRepository.getReaderById( id ) == null ) {
            throw new NoSuchElementException( "Не найдена книга с идентификатором \"" + id + "\"" );
        }
        return readerRepository.getReaderById( id );
    }

    public Reader[] getAllReaders() {
        return readerRepository.getAllReaders();
    }
}
