package com.trybe.contabancaria;

/**
 * Classe ValidaCpf.
 **/

public class ValidaCpf {

  private String cpf;

  /**
   * Construtor da classe ValidaCpf.
   */
  public static boolean validarCpf(String cpf) {

    int dv1Soma = 0;
    int mult1 = 10;
    for (int index = 0; index < 9; index++) {
      dv1Soma += Integer.parseInt(String.valueOf(cpf.charAt(index))) * mult1;
      mult1--;
    }


    int dv2Soma = 0;
    int mult2 = 11;
    for (int index = 0; index < 10; index++) {
      dv2Soma += Integer.parseInt(String.valueOf(cpf.charAt(index))) * mult2;
      mult2--;
    }

    int dv1 = Integer.parseInt(String.valueOf(cpf.charAt(9)));
    int dv2 = Integer.parseInt(String.valueOf(cpf.charAt(10)));

    if ((11 - (dv1Soma % 11)) == dv1 && (11 - (dv2Soma % 11)) == dv2) {
      return true;
    } else {
      return false;
    }
  }

  public String getCpf() {
    return this.cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

}
