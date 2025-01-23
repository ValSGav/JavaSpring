package ru.gb.springdemo.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@Entity
@Table(name = "readers")
@Schema(description = "Читатель")
public class Reader {

  @Id
  @GeneratedValue
  private Long id;
  @Schema(description = "ФИО читателя")
  @Column(name = "name")
  private String name;

  public Reader(String name) {
    this.name = name;
  }

}
