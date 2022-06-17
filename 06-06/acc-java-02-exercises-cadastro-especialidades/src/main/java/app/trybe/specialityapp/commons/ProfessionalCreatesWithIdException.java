package app.trybe.specialityapp.commons;

public class ProfessionalCreatesWithIdException extends Exception {

  private static final long serialVersionUID = 1L;

  public ProfessionalCreatesWithIdException() {
    super("Não é permitido inserir novos registros com ID explícito");
  }

}
