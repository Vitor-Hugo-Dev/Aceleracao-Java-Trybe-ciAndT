package app.trybe.specialityapp.commons;

public class ProfessionalNotExistsException extends Exception {

  private static final long serialVersionUID = 1L;

  public ProfessionalNotExistsException(String message) {
    super(message);
  }

  public ProfessionalNotExistsException() {
    super("Profissional não encontrado, insira um ID válido");
  }
}
