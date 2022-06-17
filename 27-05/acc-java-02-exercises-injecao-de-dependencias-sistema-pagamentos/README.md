### Termos e acordos

Ao iniciar este projeto, você concorda com as diretrizes do Código de Ética e Conduta e do Manual da Pessoa Estudante da Trybe.

---

# Boas vindas ao repositório do desafio da Aceleração Java!

Você já usa o GitHub diariamente para desenvolver os exercícios, certo? Agora, para desenvolver o desafio, você deverá seguir as instruções a seguir. Fique atento a cada passo, e se tiver qualquer dúvida, nos envie por _Slack_! #vqv 🚀

Aqui você vai encontrar os detalhes de como estruturar o desenvolvimento do seu desafio a partir deste repositório, utilizando uma branch específica e um _Pull Request_ para colocar seus códigos.

---
# Instruções para entregar seu projeto

## Não se esqueça de consultar as documentações!

⚠️ **Importante**:

Esse projeto tem como intuito te treinar para ter mais familiaridade com a documentação de aplicações, por tanto, poderão haver alguns comandos ou atributos que não estão no curso, mas que devem ser descritos no decorrer dos requisitos.

Nesses casos, é importante se atentar a aquilo que o requisito pede, e lembrar sempre de utilizar a [documentação oficial](https://docs.oracle.com/en/java/javase/11/) do Java para pesquisar detalhes sobre comandos.


## Antes de começar a desenvolver

Lembre-se que você pode consultar nosso conteúdo sobre [Git & GitHub](https://course.betrybe.com/intro/git/) sempre que precisar!

1. Clone o repositório
  * Por exemplo: `git clone git@github.com:tryber/desafio-aceleracao.git`
  * Entre no diretório do repositório que você acabou de clonar:
    * neste caso `cd desafio-aceleracao`

2. Instale as dependências:
    * `mvn install`

3. Crie uma branch a partir da branch `main`

  * Verifique que você está na branch `main`
    * Exemplo: `git branch`
  * Se não estiver, mude para a branch `main`
    * Exemplo: `git checkout main`
  * Agora, crie uma branch onde você vai guardar os commits do seu desafio
    * Você deve criar uma branch no seguinte formato: `nome-de-usuario-nome-do-desafio`
    * Exemplo:
      * `git checkout -b joaozinho-acc-java-sample`

4. Adicione a sua branch com o novo `commit` ao repositório remoto

  - Usando o exemplo anterior:
    - `git push -u origin joaozinho-acc-java-sample`

5. Crie um novo `Pull Request` _(PR)_
  * Vá até a aba de _Pull Requests_ deste repositório no GitHub
  * Clique no botão verde _"New pull request"_
  * Clique na caixa de seleção _"Compare"_ e escolha a sua branch **com atenção**
  * Clique no botão verde _"Create pull request"_
  * Adicione uma descrição para o _Pull Request_ e clique no botão verde _"Create pull request"_
  * **Não se preocupe em preencher mais nada por enquanto!**
  * Volte até a página de _Pull Requests_ do repositório e confira que o seu _Pull Request_ está criado
 
 ⚠️ **Lembre-se do CheckStyle! Deixe seu Eclipse configurado para arrumar o estilo automaticamente. Qualquer dúvida, volte no conteúdo.**

---

## Durante o desenvolvimento

* ⚠ **PULL REQUESTS COM ISSUES NO CHECKSTYLE NÃO SERÃO AVALIADAS, ATENTE-SE PARA RESOLVÊ-LAS ANTES DE FINALIZAR O DESENVOLVIMENTO!** ⚠

* Faça `commits` das alterações que você fizer no código regularmente

* Lembre-se de sempre após um (ou alguns) `commits` atualizar o repositório remoto

* Os comandos que você utilizará com mais frequência são:
  1. `git status` _(para verificar o que está em vermelho - fora do stage - e o que está em verde - no stage)_
  2. `git add` _(para adicionar arquivos ao stage do Git)_
  3. `git commit` _(para criar um commit com os arquivos que estão no stage do Git)_
  4. `git push -u origin nome-da-branch` _(para enviar o commit para o repositório remoto na primeira vez que fizer o `push` de uma nova branch)_
  5. `git push` _(para enviar o commit para o repositório remoto após o passo anterior)_

---

## Depois de terminar o desenvolvimento (opcional)

Para **"entregar"** seu projeto, siga os passos a seguir:

* Vá até a página **DO SEU** _Pull Request_, adicione a label de _"code-review"_ e marque seus colegas
  * No menu à direita, clique no _link_ **"Labels"** e escolha a _label_ **code-review**
  * No menu à direita, clique no _link_ **"Assignees"** e escolha **o seu usuário**
  * No menu à direita, clique no _link_ **"Reviewers"** e digite `students`, selecione o time `tryber/students-sd-0x`

Se ainda houver alguma dúvida sobre como entregar seu projeto, [aqui tem um video explicativo](https://vimeo.com/362189205).

---

# Requisitos do desafio

## Injeção de dependências em um sistema de pagamentos

Neste projeto, você vai praticar tudo o que aprendeu sobre injeção de dependências criando um projeto Spring boot com diversas camadas no qual é preciso injetar dependências entre as classes.

Para começar, crie o projeto no *Spring initialzr* com as mesmas configurações e dependências da lição anterior, somente alterando:

- grupo: com.trybe.acelaracao-java
- artefato: ioc-di

Esse projeto será dividido em algumas camadas, sendo elas as seguintes:

- configuration
- model
- controller
- repository
- service

No pacote model, crie a classe Auth com os seguintes atributos: 

- privado, do tipo String chamado usuário;
- privado, do tipo String chamado senha;
- privado, do tipo String chamado nivelDeAcesso;

Ainda nesse pacote, crie outra classe chamada Payment com os atributos:

- privado, do tipo String chamado id;
- privado, do tipo String chamado valor;

- No pacote de service, crie uma classe chamada *AuthConfigService* (iremos usá-la para configuração manual de beans, então não inclua aquela annotation que eu sei que você lembrou nela).

  * Essa classe terá somente um método público chamado *fazerLogin*, que vai retornar Auth e recebe Auth como parâmetro.

- Agora na camada de configuration, crie uma classe chamada *Config* e crie um bean para o *AuthConfigService*. Feito isso, ele estará pronto para ser injetado em outra service que vamos criar daqui a pouco.

- No pacote repository, crie uma classe chamada *PagamentoRepository* (a injeção dela e das próximas classes que vamos criar será feita via annotation, então agora pode incluir aquelas annotations que você pensou antes 😉). Essa classe terá um método:

  * Ele será público, vai retornar Pagamento e receber Pagamento e terá o nome criarPagamento;

Voltando ao pacote de service:
- Crie uma nova service chamada *PagamentoService* e logo de início injete nele a dependência do *PagamentoRepository e do AuthConfigService* via atributo.

  * Agora crie um método chamado *validarLogin*, que vai usar o *AuthConfigService* com as características:

    * público, retorna o tipo Auth, recebe como parâmetro Auth e retorna a chamada para o método fazerLogin do AuthConfigService;

    * e um método para chamarmos o nosso *PagamentoRepository*, onde criaremos um método *criarPagamento*:

    * público, retorna o tipo Pagamento, recebe Pagamento como parâmetro e retorna a chamada para o método criarPagamento da PagamentoRepository;

- Para encerrar o nosso projeto, crie uma controller chamada *PagamentoController*. Como não nos aprofundamos muito aqui em controllers, mas queremos injetar nossa service em outra classe, vou deixar aqui uma dica de como fazer a controller:

````java

@RestController //essa anotação tem a mesma funcionalidade da @Controller mas como estamos usando o SpringWeb aqui injetamos essa
public class nomedasuaController {

    //aqui você injeta a service 

    @PostMapping()
    public tipodeRetorno  nomedometodo (@RequestBody tipo tipo) {
      return   nomedaservice.metododaservice(tipo);
    }

}

````

 A controller que você vai fazer deve injetar a dependência da *PagamentoService* via atributo e ter um método bem parecido com o exemplo acima, com as seguintes características:

 - retorna Pagamento, seu nome será criarPagamento, a request será Pagamento e o retorno será a chamada para o método criarPagamento da PagamentoService;


Bora para um exercício extra?

 Crie um interceptor exatamente com as mesmas configurações das que foram explicadas em aula (no pacote *interceptor*, crie as classes *Interceptor*, *InterceptorConfig*, um Enum *Verificacao* e que a annotation seja *@RestritoPermissaoEscrita*). Crie também uma controller chamada *InterceptorController* que tenha as mesmas configurações das mostradas em aulas, porém que o endpoint *com-interceptor* tenha a annotation *@RestritoPermissaoEscrita*.


Após resolver este desafio, você saberá exatamente como injetar dependências via configuração e anotações em um projeto Spring e criar um Interceptor. 😍


---

# Avisos Finais

Ao finalizar e submeter o desafio, não se esqueça de avaliar sua experiência preenchendo o formulário. Leva menos de 3 minutos!

Link: [Formulário](https://be-trybe.typeform.com/to/PsefzL2e)

O avaliador automático não necessariamente avalia seu projeto na ordem em que os requisitos aparecem no readme. Isso acontece para deixar o processo de avaliação mais rápido. Então, não se assuste se isso acontecer, ok?

---