package com.trybe.spring.application;

import com.trybe.spring.domain.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Controller;

@Controller
@Path("/api/books")
public class BookController {

  private List<Book> books = new ArrayList<>();

  /**
   * add.
   * 
   * @param book - book.
   * @return - book.
   */
  @POST
  @Consumes("application/json")
  @Produces("application/json")
  public Response add(Book book) {
    Book newBook = new Book(book.getName(), book.getAuthor());
    books.add(newBook);
    return Response.ok(newBook).build();
  }

  /**
   * findAll.
   * 
   * @return - lista de livros.
   */
  @GET
  @Consumes("application/json")
  @Produces("application/json")
  public Response findAll() {
    return Response.ok(books).build();
  }

  /**
   * findById.
   * 
   * @param id - id do livro.
   * @return - livro.
   */
  @GET
  @Path("/{id}")
  @Consumes("application/json")
  @Produces("application/json")
  public Response findById(@PathParam("id") UUID id) {
    try {
      Book book = books.stream().filter(b -> b.getId().equals(id)).findAny().orElseThrow();
      return Response.ok(book).build();
    } catch (NoSuchElementException e) {
      return Response.status(404).build();
    }
  }

  /**
   * update.
   * 
   * @param id   - id do livro a ser atualizado
   * @param book - livro com os novos dados
   * @return - livro atualizado
   */
  @PUT
  @Path("/{id}")
  @Consumes("application/json")
  @Produces("application/json")
  public Response update(@PathParam("id") UUID id, Book book) {
    try {
      Book bookToUpdate = books.stream().filter(b -> b.getId().equals(id)).findAny().orElseThrow();
      bookToUpdate.setName(book.getName());
      bookToUpdate.setAuthor(book.getAuthor());
      return Response.ok(bookToUpdate).build();
    } catch (NoSuchElementException e) {
      return Response.status(404).build();
    }
  }

  /**
   * remove.
   * 
   * @param id - id do livro a ser deletado.
   * @return - Response.ok() se o livro foi deletado com sucesso.
   */
  @DELETE
  @Path("/{id}")
  public Response remove(@PathParam("id") UUID id) {
    try {
      Book bookToDelete = books.stream().filter(b -> b.getId().equals(id)).findAny().orElseThrow();
      books.remove(bookToDelete);
      return Response.status(204).build();
    } catch (NoSuchElementException e) {
      return Response.status(404).build();
    }
  }
}
