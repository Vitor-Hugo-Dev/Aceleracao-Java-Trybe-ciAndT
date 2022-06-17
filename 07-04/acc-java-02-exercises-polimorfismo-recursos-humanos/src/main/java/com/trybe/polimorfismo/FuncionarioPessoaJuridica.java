package com.trybe.polimorfismo;

public class FuncionarioPessoaJuridica extends Funcionario {

  @Override
  public double calcularSalarioLiquido() {
    double salario = this.salarioBruto;

    return salario - (salario * 0.1);
  }

}
