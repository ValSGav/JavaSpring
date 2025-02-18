package ru.gb.springdemo.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Запись о факте выдачи книги (в БД)
 */
@Data
@Entity
@Table(name = "issues")
@Schema(description = "Факт выдачи книги")
public class Issue {

  //public static long sequence = 1L;

  @Id
  @GeneratedValue
  private  Long id;
  @Schema(description = "id книги")
  @Column(name = "book_id")
  private  long bookId;
  @Schema(description = "id читателя")
  @Column(name = "reader_id")
  private  long readerId;

  /**
   * Дата выдачи
   */
  @Column(name = "issued_at")
  private LocalDateTime issuedAt;
  @Column(name = "returned_at")
  private LocalDateTime returnedAt;

  public Issue(long bookId, long readerId) {
    //this.id = sequence++;
    this.bookId = bookId;
    this.readerId = readerId;
    this.issuedAt = LocalDateTime.now();
  }

  public Issue() {
  }
}
