package com.trybe.conversorcsv;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Conversor {

  /**
   * Função utilizada apenas para validação da solução do desafio.
   *
   * @param args Não utilizado.
   * @throws IOException Caso ocorra algum problema ao ler os arquivos de entrada
   *                     ou gravar os
   *                     arquivos de saída.
   */
  public static void main(String[] args) throws IOException {
    File pastaDeEntradas = new File("./entradas/");
    File pastaDeSaidas = new File("./saidas/");
    new Conversor().converterPasta(pastaDeEntradas, pastaDeSaidas);
  }

  /**
   * Converte todos os arquivos CSV da pasta de entradas. Os resultados são
   * gerados na pasta de
   * saídas, deixando os arquivos originais inalterados.
   *
   * @param pastaDeEntradas Pasta contendo os arquivos CSV gerados pela página
   *                        web.
   * @param pastaDeSaidas   Pasta em que serão colocados os arquivos gerados no
   *                        formato requerido pelo
   *                        subsistema.
   *
   * @throws IOException Caso ocorra algum problema ao ler os arquivos de entrada
   *                     ou gravar os
   *                     arquivos de saída.
   */
  public void converterPasta(File pastaDeEntradas, File pastaDeSaidas) throws IOException {

    /**
     * verifica se a pasta de entrada existe (V) verifica se a pasta de entrada é
     * uma pasta (V)
     * verifica se a pasta de saída existe (V) se a parta de saida não existe, cria
     * (V) le os
     * arquivos da pasta de entrada um por um (V) cria os metodos de conversão cria
     * o arquivo de
     * saida
     */
    if (!pastaDeEntradas.exists()) {
      throw new IOException("Pasta de entrada não existe");
    }
    if (!pastaDeEntradas.isDirectory()) {
      throw new IOException("Pasta de entrada não pode ser lida");
    }
    if (!pastaDeSaidas.exists()) {
      pastaDeSaidas.mkdir();
    }
    if (!pastaDeEntradas.canRead()) {
      throw new IOException("Pasta de entrada não pode ser lida");
    }

    File[] arquivos = pastaDeEntradas.listFiles();

    for (File arquivo : arquivos) {
      if (arquivo.isFile()) {
        String fileName = arquivo.getName();

        FileReader myFileReader = new FileReader(arquivo);
        BufferedReader myBufferedReader = new BufferedReader(myFileReader);
        FileWriter myFileWriter = new FileWriter(pastaDeSaidas + "/" + fileName);
        BufferedWriter myBufferedWriter = new BufferedWriter(myFileWriter);

        try {
          String linha = myBufferedReader.readLine();
          myBufferedWriter.write(linha + "\n");
          linha = myBufferedReader.readLine();
          while (linha != null) {
            String newLine = this.formatLine(linha);
            if (newLine != null) {
              myBufferedWriter.write(newLine + "\n");
            }
            linha = myBufferedReader.readLine();
          }
          myBufferedWriter.flush();
        } catch (IOException e) {
          e.printStackTrace();
        } finally {
          this.closeFiles(myFileReader, myBufferedReader, myFileWriter, myBufferedWriter);
        }
      }
    }
  }

  /**
   * formata a linha de entrada para o formato de saida.
   */
  private String formatLine(String line) {
    String[] parts = line.split(",");
    StringBuilder formatedLine = new StringBuilder();
    String name = parts[0].toUpperCase();
    String[] data = parts[1].split("/");
    String birthDate = data[2] + "-" + data[1] + "-" + data[0];
    String email = parts[2].toLowerCase();
    String cpf = parts[3];
    String formatedCpf = cpf.substring(0, 3) + "." + cpf.substring(3, 6) + "." + cpf.substring(6, 9)
        + "-" + cpf.substring(9, 11);
    return formatedLine.append(name + ",").append(birthDate + ",").append(email + ",")
        .append(formatedCpf).toString();
  }

  /**
   * Fecha os arquivos de entrada e saída.
   */
  private void closeFiles(FileReader fileReader, BufferedReader bufferedReader,
      FileWriter fileWriter, BufferedWriter bufferedWriter) {
    try {
      fileReader.close();
      bufferedReader.close();
      fileWriter.close();
      bufferedWriter.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
