package ru.gb.springdemo.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@Entity
@Table(name = "users")
public class Book {

  //public static long sequence = 1L;

  @Id
  @GeneratedValue
  private Long id;
  @Column(name="name")
  private String name;

//  public Book(String name) {
//    this(sequence++, name);
//  }

  public Book(String name) {
    this.name = name;
  }
}
