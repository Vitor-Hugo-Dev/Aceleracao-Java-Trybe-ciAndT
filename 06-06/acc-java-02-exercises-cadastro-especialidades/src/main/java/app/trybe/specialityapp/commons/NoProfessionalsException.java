package app.trybe.specialityapp.commons;

public class NoProfessionalsException extends Exception {

  private static final long serialVersionUID = 1L;

  public NoProfessionalsException() {
    super("Nenhum registro foi encontrado!");
  }

}
