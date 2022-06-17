package app.trybe.specialityapp.commons;

import javax.ws.rs.core.Response.Status;

public class ApplicationError extends Exception {

  private static final long serialVersionUID = 1L;

  private Status status;
  private String message;

  public ApplicationError(String message, Status status) {
    this.message = message;
    this.status = status;
  }

  public Status getStatus() {
    return this.status;
  }

  public String getMessage() {
    return this.message;
  }

}
