package com.trybe.spring.domain;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

public class Book implements Serializable {

  private UUID id;

  private String name;

  private String author;

  /**
   * metodo construtor.
   * 
   * @param name   - nome do livro.
   * @param author - autor do livro.
   */
  public Book(String name, String author) {
    this.id = UUID.randomUUID(); // toda nova instância terá um novo id
    this.name = name;
    this.author = author;
  }

  /**
   * metodo construtor.
   */
  public Book(Book book) {
    this.name = book.getName();
    this.author = book.getAuthor();
    this.id = UUID.randomUUID();
  }

  /**
   * metodo construtor.
   */
  public Book() {
  }

  public UUID getId() {
    return this.id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAuthor() {
    return this.author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Book book = (Book) obj;
    return id.equals(book.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}