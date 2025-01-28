package ru.gb.springdemo.service;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.springdemo.model.Reader;
import ru.gb.springdemo.repository.ReaderRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ReaderService {

    private final ReaderRepository readerRepository;

    @PostConstruct
    void createSomeReaders() {
        readerRepository.save(new Reader("Igor"));
        readerRepository.save(new Reader("Semen"));
        readerRepository.save(new Reader("Olga"));
    }

    public void deleteReader(long id) {
        if (readerRepository.getById(id) == null) {
            throw new NoSuchElementException("Не найдена книга с идентификатором \"" + id + "\"");
        }
        readerRepository.deleteById(id);
    }

    public Reader createReader(String name) {
        return readerRepository.save(new Reader(name));
    }

    public Reader ReaderInfo(long id) {
        if (readerRepository.getById(id) == null) {
            throw new NoSuchElementException("Не найдена книга с идентификатором \"" + id + "\"");
        }
        return readerRepository.getById(id);
    }

    public List<Reader> getAllReaders() {
        List<Reader> readers = readerRepository.findAll();
        return readers;
    }


}
