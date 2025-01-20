package ru.gb.springdemo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.springdemo.model.Reader;
import ru.gb.springdemo.repository.ReaderRepository;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ReaderService {

    private final ReaderRepository readerRepository;

    public void deleteReader(long id) {
        if ( readerRepository.getById( id ) == null ) {
            throw new NoSuchElementException( "Не найдена книга с идентификатором \"" + id + "\"" );
        }
        readerRepository.deleteById( id );

    }

    public Reader createReader(String name) {
        return readerRepository.save( new Reader( name ) );
    }

    public Reader ReaderInfo(long id) {
        if ( readerRepository.getById( id ) == null ) {
            throw new NoSuchElementException( "Не найдена книга с идентификатором \"" + id + "\"" );
        }
        return readerRepository.getById( id );
    }

    public Reader[] getAllReaders() {
        return (Reader[]) readerRepository.findAll().toArray();
    }
}
