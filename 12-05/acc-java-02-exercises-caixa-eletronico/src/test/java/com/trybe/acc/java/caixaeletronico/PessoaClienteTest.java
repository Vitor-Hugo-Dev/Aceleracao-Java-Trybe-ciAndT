package com.trybe.acc.java.caixaeletronico;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

@DisplayName("Teste dos métodos da classe PessoaCliente")
class PessoaClienteTest {
  private final ByteArrayOutputStream testeConsole = new ByteArrayOutputStream(); // https://www.tutorialspoint.com/java/java_bytearrayoutputstream.htm

  private final PrintStream consolePadrao = System.out; // https://www.devmedia.com.br/destrinchando-a-classe-java-lang-system/29808

  private PessoaCliente pessoaCliente;
  private Conta conta;
  private String nome = "Dino o sauro";
  private String cpf = "123456789";
  private String senha = "40028922"; // é o funk do yud que vai dar ps2

  @BeforeEach
  void beroreEach() {
    System.setOut(new PrintStream(testeConsole)); // muda a saida para poder testar.

    pessoaCliente = new PessoaCliente(nome, cpf, senha);
    conta = new Conta("Corrente", pessoaCliente, new Banco());
    conta.adicionarTransacao(100.00, "Depósito");
    pessoaCliente.adicionarConta(conta);
  }

  @AfterEach
  void afterEach() {
    System.setOut(consolePadrao); // restaura para a saída padrão.
  }

  @Test
  @DisplayName("12 - Testa o construtor da classe Pessoa Cliente.")
  void construtorTest() {
    String mensagemEsperada = "Nova Pessoa Dino o sauro com CPF: 123456789 criada com sucesso!";
    assertEquals(mensagemEsperada, testeConsole.toString().trim());
    /**
     * .trim() remove espaços iniciais e finais. (espaços são qualquer caractere
     * menor ou igual a'U+0020' (SPACE))
     */
  }

  @Test
  @DisplayName("13 - Testa o método adicionar conta e o método retornar número de contas.")
  void adicionarContaTestRetornaNumeroDeContasTest() {
    assertEquals(1, pessoaCliente.retornarNumeroDeContas());
  }

  @Test
  @DisplayName("14 - Testa o método retornar saldo de uma conta específica da pessoa cliente.")
  void retornarSaldoContaEspecificaTest() {
    int indice = 0;
    double saldo = 100.00;
    assertEquals(saldo, pessoaCliente.retornarSaldoContaEspecifica(indice));
  }

  @Test
  @DisplayName("15 - Testa o método retornar id de uma conta específica da pessoa cliente.")
  void retornarIdContaEspecificaTest() {
    int indice = 0;
    assertEquals(conta.getIdConta(), pessoaCliente.retornarIdContaEspecifica(indice));

  }

  @Test
  @DisplayName("16 - Testa o método retornar o extrato de uma conta específica da pessoa cliente.")
  void retornarExtratoContaEspecificaTest() {
    int indice = 0;
    pessoaCliente.retornarExtratoContaEspecifica(indice);
    assertTrue(testeConsole.toString().contains("Descrição: Depósito Quantia: 100.0"));

  }

  @Test
  @DisplayName("17 - Testa o método adiciona transacao de uma conta específica da pessoa cliente.")
  void adicionarTransacaoContaEspecificaTest() {
    pessoaCliente.adicionarTransacaoContaEspecifica(0, -100.00, "Saque");
    pessoaCliente.retornarExtratoContaEspecifica(0);

    assertTrue(testeConsole.toString().contains("Descrição: Saque Quantia: -100.0"));

  }

  @Test
  @DisplayName("18 - Testa o método validar senha.")
  void validarSenhaTest() {
    assertTrue(pessoaCliente.validarSenha(senha));
  }

  @Test
  @DisplayName("19 - Testa o método retornar resumo contas.")
  void retornarResumoContasTest() {
    testeConsole.reset();
    pessoaCliente.retornarResumoContas();
    String resumo = new StringBuilder()
        .append("ID da conta: " + conta.getIdConta() + "\n")
        .append("Tipo da conta: " + "Corrente" + "\n")
        .append("Saldo: " + "100.0" + "\n")
        .toString().trim();

    assertEquals(resumo, testeConsole.toString().trim());

  }

  @Test
  @DisplayName("20 - Testa o método Getter do atributo cpf está retornando.")
  void getCpfTest() {
    assertEquals(cpf, pessoaCliente.getCpf());

  }

}
