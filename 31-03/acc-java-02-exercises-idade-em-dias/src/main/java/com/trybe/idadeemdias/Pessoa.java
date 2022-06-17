package com.trybe.idadeemdias;

public class Pessoa {

  /**
   * Calcula a idade em dias.
   * 
   * @param anos - converte anos em dias
   * @param meses - converte meses em dias
   * @param dias - retorna os dias
   * @return soma e retorna os valores das conversões anteriores.
   */
  public int calcularIdadeEmDias(int anos, int meses, int dias) {
    int anosEmDias = anos * 365;

    int mesesEmDias = meses * 30;

    return anosEmDias + mesesEmDias + dias;
  }
}
