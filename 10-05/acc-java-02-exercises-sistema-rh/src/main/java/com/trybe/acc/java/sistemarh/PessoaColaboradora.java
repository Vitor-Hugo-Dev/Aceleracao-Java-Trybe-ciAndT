package com.trybe.acc.java.sistemarh;

public class PessoaColaboradora {

  private double salarioBruto;

  /**
   * calcularSalarioLiquido.
   * calcula o salario liquido.
   * @return retorna o salario liquido.
   */
  public double calcularSalarioLiquido() {
    double salarioLiquido = getSalarioBruto() * 0.8;

    return (double) salarioLiquido;
  }

  /**
   * calcularValorBrutoRecebidoAnual.
   * calcula o valor bruto recebido em x anos.
   * @param ano recebe o numero de anos.
   * @return retorna o valor bruto recebido em x anos.
   */
  public double calcularValorBrutoRecebidoAnual(int ano) {
    double valorBrutoRecebidoAnual = getSalarioBruto() * 12;

    return (double) valorBrutoRecebidoAnual * ano;
  }

  /**
   * calcularValorLiquidoRecebidoAnual.
   * calcula o valor liquido recebido em x anos.
   * @param ano recebe o numero de anos.
   * @return retorna o valor liquido recebido em x anos.
   */
  public double calcularValorLiquidoRecebidoAnual(int ano) {
    double valorLiquidoRecebidoAnual = calcularSalarioLiquido() * 12;

    return (double) valorLiquidoRecebidoAnual * ano;
  }

  /**
   * calcularValorImpostoAnual.
   * calcula o valor do imposto em x anos.
   * @param ano recebe o numero de anos.
   * @return retorna o valor do imposto em x anos.
   */
  public double calcularValorImpostoAnual(int ano) {
    double valorImpostoAnual = calcularValorBrutoRecebidoAnual(ano) * 0.2;

    return (double) valorImpostoAnual;
  }

  public double getSalarioBruto() {
    return this.salarioBruto;
  }

  public void setSalarioBruto(double salarioBruto) {
    this.salarioBruto = salarioBruto;
  }

}