package ru.gb.springdemo.api;

import lombok.Data;

@Data
public class ReaderRequest {
    /**
     * Идентификатор читателя
     */
    private long readerId;
    /**
     * Имя читателя
     */
    private String name;
}
