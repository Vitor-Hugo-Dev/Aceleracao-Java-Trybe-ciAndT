package com.trybe.polimorfismo;

public abstract class Funcionario {
  protected String nome;
  protected String cpf;
  protected double salarioBruto;

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public double getSalarioBruto() {
    return salarioBruto;
  }

  public void setSalarioBruto(double salarioBruto) {
    this.salarioBruto = salarioBruto;
  }

  public double calcularSalarioLiquido() {
    return salarioBruto;
  }


}
