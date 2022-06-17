package com.trybe.polimorfismo;

public class FuncionarioPessoaFisica extends Funcionario {

  @Override
  public double calcularSalarioLiquido() {
    double salario = this.salarioBruto;
    
    return salario - (salario * 0.2);
  }

  
}
