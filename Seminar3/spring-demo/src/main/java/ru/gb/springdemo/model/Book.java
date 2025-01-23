package ru.gb.springdemo.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@Entity
@Table(name = "users")
@Schema(description = "Книга")
public class Book {

  //public static long sequence = 1L;

  @Id
  @GeneratedValue
  private Long id;
  @Column(name="name")
  @Schema(description = "Название книги", example = "Война и мир")
  private String name;

//  public Book(String name) {
//    this(sequence++, name);
//  }

  public Book(String name) {
    this.name = name;
  }
}
