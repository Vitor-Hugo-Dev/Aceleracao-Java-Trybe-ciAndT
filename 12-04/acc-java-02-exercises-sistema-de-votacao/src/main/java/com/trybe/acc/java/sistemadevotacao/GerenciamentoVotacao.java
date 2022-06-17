package com.trybe.acc.java.sistemadevotacao;

import java.util.ArrayList;

public class GerenciamentoVotacao {
  private ArrayList<PessoaCandidata> pessoasCandidatas = new ArrayList<PessoaCandidata>();
  private ArrayList<PessoaEleitora> pessoasEleitoras = new ArrayList<PessoaEleitora>();
  private ArrayList<String> cpfComputado = new ArrayList<String>();
  private int totalVotos = 0;

  /**
   * cadastrarPessoaCandidata.
   * 
   * @param nome = nome do candidato
   * @param numero = numero do candidato
   */
  public void cadastrarPessoaCandidata(String nome, int numero) {

    boolean verify = false;
    for (PessoaCandidata pessoaCandidata : pessoasCandidatas) {
      if (pessoaCandidata.getNumero() == numero) {
        verify = true;
        break;
      }
    }
    if (verify) {
      System.out.println("Número pessoa candidata já utilizado!");
    } else {
      PessoaCandidata pessoaCandidata = new PessoaCandidata(nome, numero);
      pessoasCandidatas.add(pessoaCandidata);
    }
  }

  /**
   * cadastrarPessoaEleitora.
   * 
   * @param nome = nome do eleitor
   * @param cpf = cpf do eleitor
   */
  public void cadastrarPessoaEleitora(String nome, String cpf) {
    boolean verify = false;

    for (PessoaEleitora pessoaEleitora : pessoasEleitoras) {
      if (pessoaEleitora.getCpf().equals(cpf)) {
        verify = true;
        break;
      }
    }
    if (verify) {
      System.out.println("Pessoa eleitora já cadastrada!");
    } else {
      PessoaEleitora pessoaEleitora = new PessoaEleitora(nome, cpf);
      pessoasEleitoras.add(pessoaEleitora);
    }
  }

  /**
   * votar.
   * 
   * @param cpfPessoaEleitora = cpf do eleitor
   * @param numeroPessoaCandidata = numero do candidato
   */
  public void votar(String cpfPessoaEleitora, int numeroPessoaCandidata) {
    boolean verify = false;
    for (String currentCpf : cpfComputado) {
      if (currentCpf.equals(cpfPessoaEleitora)) {
        verify = true;
        break;
      }
    }
    if (verify) {
      System.out.println("Pessoa eleitora já votou!");
    } else {
      for (PessoaCandidata pessoaCandidata : pessoasCandidatas) {
        if (pessoaCandidata.getNumero() == numeroPessoaCandidata) {
          pessoaCandidata.receberVoto();
          break;
        }
      }
      this.totalVotos += 1;
      cpfComputado.add(cpfPessoaEleitora);
    }
  }

  /**
   * mostrarResultado.
   */
  public void mostrarResultado() {
    if (totalVotos == 0) {
      System.out.println("É preciso ter pelo menos um voto para mostrar o resultado.");
    } else {
      StringBuilder response = new StringBuilder();
      for (int index = 0; index < pessoasCandidatas.size(); index += 1) {
        StringBuilder currentCandidato = new StringBuilder();
        currentCandidato.append("Nome: ").append(pessoasCandidatas.get(index).getNome() + " - ")
            .append(pessoasCandidatas.get(index).getVotos() + " votos")
            .append("( " + calcularPorcentagemVotos(index) + "% )");
        response.append(currentCandidato + "\n");
      }
      response.append("Total de votos: ").append(totalVotos);
      System.out.println(response + "\n");
    }

  }

  private double calcularPorcentagemVotos(int candidatoIndex) {
    double total = Math.round(totalVotos);
    double candidatoVotos = Math.round(pessoasCandidatas.get(candidatoIndex).getVotos());

    return (double) (candidatoVotos * 100) / total;
  }



}
