package ru.gb.springdemo.service;

import org.springframework.stereotype.Service;
import ru.gb.springdemo.aspect.RecoverException;


@Service
public class RecoverExceptionTestService {
    @RecoverException
    public int test1() {
        throw new RuntimeException();
    }

    @RecoverException
    public boolean test2() {
        throw new NullPointerException();
    }
}
