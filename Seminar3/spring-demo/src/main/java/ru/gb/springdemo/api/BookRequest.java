package ru.gb.springdemo.api;

import lombok.Data;

@Data
public class BookRequest {
    /**
     * Имя книги
     */
    private String name;
    /**
     * id Книги
     */
    private long id;
}
