package com.trybe.acc.java.caixaeletronico;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Testes para a classe Banco")
class BancoTest {
  private final ByteArrayOutputStream testeConsole = new ByteArrayOutputStream(); // https://www.tutorialspoint.com/java/java_bytearrayoutputstream.htm
  private final PrintStream consolePadrao = System.out; // https://www.devmedia.com.br/destrinchando-a-classe-java-lang-system/29808

  private Banco banco;
  private PessoaCliente criaPessoa;

  @BeforeEach
  void beforeEach() {
    System.setOut(new PrintStream(testeConsole)); // muda a saida do console para poder testar as transaçoes.
    banco = new Banco();
    criaPessoa = banco.adicionarPessoaCliente("Dino o sauro", "Corrente", "121.121.121-12", "40028922");
  }

  @AfterEach
  void afterEach() {
    System.setOut(consolePadrao); // restaura para a saida padrão.
  }

  @Test
  @DisplayName("1 - Testa o gerador de número único para nova conta.")
  void gerarNumeroNovaContaTest() {

    String numero = banco.gerarNumeroNovaConta();
    assertEquals(10, numero.length());
  }

  @Test
  @DisplayName("2 - Testa o método adicionar pessoa cliente retorna o objeto pessoa cliente.")
  void adicionarPessoaClienteTest() {

    PessoaCliente pessoa = banco.getPessoa(0);
    assertEquals(pessoa, criaPessoa);
  }

  @Test
  @DisplayName("3 - Testa o método login da pessoa cliente retorna o objeto pessoa cliente corretamente.")
  void pessoaClienteLoginTest() {
    String cpf = "121.121.121-12";
    String senha = "40028922";
    PessoaCliente pessoa = banco.getPessoa(0);

    assertEquals(pessoa, banco.pessoaClienteLogin(cpf, senha));
  }

  @Test
  @DisplayName("4 - Testa se o método transferir fundos está transferindo corretamente.")
  void depositarTestTransferirFundosTestmostrarExtratoTest() {
    Conta contaPoupanca = new Conta("Poupança", criaPessoa, banco);
    String cpf = "121.121.121-12";
    String senha = "40028922";
    PessoaCliente pessoaLogada = banco.pessoaClienteLogin(cpf, senha);
    banco.depositar(pessoaLogada, 0, 100.00);
    pessoaLogada.adicionarConta(contaPoupanca);
    banco.transferirFundos(pessoaLogada, 0, 1, 50.00);
    banco.mostrarExtrato(pessoaLogada, 0);

    assertTrue(testeConsole.toString().contains("Descrição: Depósito"));
    assertTrue(testeConsole.toString().contains("Quantia: 100.0"));
    assertTrue(testeConsole.toString().contains("Descrição: Transferência para conta"));
    assertTrue(testeConsole.toString().contains("Quantia: -50.0"));

    banco.mostrarExtrato(pessoaLogada, 1);
    assertTrue(testeConsole.toString().contains("Descrição: Recebimento de transferência"));
    assertTrue(testeConsole.toString().contains("Quantia: 50.0"));
  }

  @Test
  @DisplayName("5 - Testa se o método sacar está funcionando corretamente.")
  void depositarTestSacarTestMostrarExtratoTest() {
    String cpf = "121.121.121-12";
    String senha = "40028922";
    PessoaCliente pessoaLogada = banco.pessoaClienteLogin(cpf, senha);
    banco.depositar(pessoaLogada, 0, 100.00);
    banco.sacar(pessoaLogada, 0, 50.00);
    banco.mostrarExtrato(pessoaLogada, 0);
    assertTrue(testeConsole.toString().contains("Descrição: Saque"));
    assertTrue(testeConsole.toString().contains("Quantia: -50.0"));
  }

}
