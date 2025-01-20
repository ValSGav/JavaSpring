package ru.gb.springdemo.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@Entity
@Table(name = "readers")
public class Reader {

  @Id
  @GeneratedValue
  private Long id;
  @Column(name = "name")
  private String name;

  public Reader(String name) {
    this.name = name;
  }

}
