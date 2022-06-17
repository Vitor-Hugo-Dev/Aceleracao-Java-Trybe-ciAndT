package com.trybe.acc.java.geradorsenhas;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GeradorSenhas {
  public static final Integer NUM_SENHAS = 10;

  // TROQUE O CAMINHO PARA O DIRETORIO DE DESTINO DOS SEUS ARQUIVOS
  public static final String DIRETORIO_DESTINO =
      "/home/vitor/Java-projects/13-04/acc-java-02-exercises-gerador-senhas/src/docs";

  /**
   * Método principal.
   */
  public static void main(String[] args) {
    GeradorSenhas gerador = new GeradorSenhas();

    for (int i = 0; i < NUM_SENHAS; i++) {

      File arquivo = new File(DIRETORIO_DESTINO + File.separator + "arquivo_" + i + ".txt");
      String senha = gerador.gerarSenhaCompleta(i);

      try {
        gerador.escreverSenhaNoArquivo(senha, arquivo);
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  /**
   * Recebe uma senha e a escreve em arquivo.
   */
  public void escreverSenhaNoArquivo(String senha, File arquivo) throws IOException {

    FileWriter escritorArquivo = null;

    BufferedWriter bufferedEscritor = null;

    try {
      escritorArquivo = new FileWriter(arquivo);

      bufferedEscritor = new BufferedWriter(escritorArquivo);
      bufferedEscritor.write(senha);
      bufferedEscritor.flush();

    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      escritorArquivo.close();
      bufferedEscritor.close();
    }
  }

  /**
   * Gera senha completa a partir do índice.
   */
  public String gerarSenhaCompleta(int indice) {
    // ESCREVA SEU CÓDIGO AQUI
    String[] senhas = new String[] {"A5$2", "B55S", "CFFG", "D&54", "EEDF", "FEGG", "G15E", "H123",
        "I81F", "JWEF", "####"};
    return senhas[indice].concat(senhas[indice + 1]);
  }
}
