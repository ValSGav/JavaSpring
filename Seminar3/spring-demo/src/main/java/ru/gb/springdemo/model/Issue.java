package ru.gb.springdemo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Запись о факте выдачи книги (в БД)
 */
@Data
@Entity
@Table(name = "issues")
public class Issue {

  public static long sequence = 1L;

  @Id
  private final Long id;
  @Column(name = "book_id")
  private final long bookId;
  @Column(name = "reader_id")
  private final long readerId;

  /**
   * Дата выдачи
   */
  @Column(name = "issued_at")
  private final LocalDateTime issuedAt;
  @Column(name = "returned_at")
  private LocalDateTime returnedAt;

  public Issue(long bookId, long readerId) {
    this.id = sequence++;
    this.bookId = bookId;
    this.readerId = readerId;
    this.issuedAt = LocalDateTime.now();
  }

}
