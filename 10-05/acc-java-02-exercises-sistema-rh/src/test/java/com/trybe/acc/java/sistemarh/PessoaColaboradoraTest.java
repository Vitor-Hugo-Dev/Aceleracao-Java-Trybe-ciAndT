package com.trybe.acc.java.sistemarh;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PessoaColaboradoraTest {


  @Test
  @DisplayName("10. com um salario bruto de 3000 o liquido deve ser 2400.")
  public void testeCalcularSalarioLiquido() {
    PessoaColaboradora pessoaColaboradora = new PessoaColaboradora();
    pessoaColaboradora.setSalarioBruto(3000);
    assertEquals(2400, pessoaColaboradora.calcularSalarioLiquido());
  }


  @Test
  @DisplayName("11. com um salario bruto de 3000 mil o valor bruto recebito em 5 anos é 180000")
  public void testeCalcularValorBrutoRecebidoAnual() {
    PessoaColaboradora pessoaColaboradora = new PessoaColaboradora();
    pessoaColaboradora.setSalarioBruto(3000);
    assertEquals(180000, pessoaColaboradora.calcularValorBrutoRecebidoAnual(5));
  }


  @Test
  @DisplayName("12. com um salario bruto de 2400 mil o valor bruto recebito em 5 anos é 144000")
  public void testeCalcularValorLiquidoRecebidoAnual() {
    PessoaColaboradora pessoaColaboradora = new PessoaColaboradora();
    pessoaColaboradora.setSalarioBruto(3000);
    assertEquals(144000, pessoaColaboradora.calcularValorLiquidoRecebidoAnual(5));
  }


  @Test
  @DisplayName("13. com um salario bruto de 3000 mil o valor de imposto pago em 5 anos é 36000")
  public void testeCalcularValorImpostoAnual() {
    PessoaColaboradora pessoaColaboradora = new PessoaColaboradora();
    pessoaColaboradora.setSalarioBruto(3000);
    assertEquals(36000, pessoaColaboradora.calcularValorImpostoAnual(5));
  }

}
