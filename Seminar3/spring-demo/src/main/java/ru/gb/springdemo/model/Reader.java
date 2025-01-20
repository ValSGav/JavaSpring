package ru.gb.springdemo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@Entity
@Table(name = "readers")
public class Reader {

  public static long sequence = 1L;

  @Id
  private final Long id;
  @Column(name = "name")
  private final String name;

  public Reader(String name) {
    this(sequence++, name);
  }

}
