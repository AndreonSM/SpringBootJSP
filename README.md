# Atividade técnica - [REDACTED]

---

## *Delevoped by*
**Andreon Souza de Medeiros Roseira**

---

## Propósito
Este é um projeto feito com dois objetivos:
- Ser visto por quem interessar;
- Diversão e aprendizado!

---

## Descrição do projeto

Este repositório consiste em uma aplicação Java Web que utiliza Spring Boot e JSF e é intencionada para um banco de dados PostgreSQL.

O objetivo da atividade é, baseado em um banco com certas tabelas (`pessoa`, `cargo`, `vencimentos` e `cargo_vencimentos`), criar e preencher uma nova tabela (`pessoa_salario_consolidado`) com os dados provenientes das tabelas já existentes no banco, onde precisa fazer certas operações em ambiente Java para obter os dados na formatação desejada - esses dados são o `ID`, o `nome`, o `cargo` e o `salario` de uma pessoa.

De forma mais específica, o sistema deve ser capaz de salvar esses dados na nova tabela (o `ID`, `nome` e o `cargo` estão presentes nas primeiras tabelas; o `salario` precisa ser calculado com base nos dados delas e só depois salvo) e imprimi-los em uma tela com nome ***Listagem de Pessoas***. Também foi pedido uma opção para o cálculo/recálculo de salários.

---
### Endpoints

Por padrão, o projeto está configurado para rodar na `porta 8090`.

No projeto, os endpoints de interesse são:
* O que exibe a listagem de pessoas, requisito da atividade : `/listagem`
* O que mostra a tabela de vencimentos, para ver melhor as regras : `/vencimentos`
* O que mostra dados-chave de uma pessoa, baseado no ID dela na tabela: `/pessoas/{id}`
* O que serve para validar se a aplicação está reconhecendo as JSPs: `/`

EDIT 18:37 03/05/2024 - New endpoints:

* Tela de criação de Pessoa com alguns dos campos mais importantes: `/pessoas/criar`

* Tela de edição de Pessoa com alguns dos campos mais importantes: `/pessoas/editar/{id}`; precisa ser um ID existente - não foi feito o tratamento para casos de ID inválido!

* O que remove uma pessoa da tabela "Pessoa": `/pessoas/excluir/{id}`; de igual modo ao anterior, precisa ser um ID existente e não há tratamento para casos de ID inválidos. Penso em fazer, futuramente, um pop-up alertando a exclusão. Ou seja: <font color="red">**CUIDADO! ASSIM QUE ACESSAR O ENDPOINT, A PESSOA É AUTOMATICAMENTE EXCLUÍDO!**</font>

Esses são os que devem ser usados corriqueiramente.

Na tela de listagem, ao apertar o botão, deve-se aguardar um momento até que termine o processamento de informações ao banco, onde será levado para outro endpoint, o `/salario/atualizar-consolidados`, que é só um Response de confirmação que o processo teve êxito.

---

## O que foi feito

### 1 - Criação do banco
O banco, para o propósito dessa atividade, foi feito **"do zero"**. 

Inicialmente, o banco foi alimentado com quatro tabelas (`pessoa`, `cargo`, `vencimentos` e `cargo_vencimentos`) através de uma importação de uma planilha do excel com dados - foi gerado o arquivo .csv para cada uma delas. O código utilizado está no diretório "extras", por nome `script_criacao_import_dados.sql`. **IMPORTANTE**: Preencha os paths dos .csv do script de acordo com a sua localidade, se for fazer algo em ambiente local!!

<font color="red">Adendo importante: uma das colunas de dados da tabela "pessoa" precisou ser tratada - a data de nascimento. </font> Essa operação foi feita utilizando um notebook em Python (presente no diretório "extras" do projeto). Da mesma forma que o script, preencha os nomes de arquivos presente no código Python de acordo com os seus. Tem dois arquivos, nessa pasta, que mostram a diferença do input e do output.

Logo após, foi criado a tabela "pessoa_salario_consolidado" com seus respectivos campos, mas sem nenhum registro. 

O formato de todas essas tabelas são consultáveis no pacote "model" do projeto.

### 2 - Configuração do projeto

A parte operacional foi feita pensado no modelo MVC, onde ocorre a implementação do arquétipo do banco, consultas ao banco de dados, operações com os dados consultados e preenchimento das tabelas com novos dados. 

O projeto usa Maven para gerenciamento de dependências; checar o arquivo "pom.xml" caso queira ver o que é usado.

Também vale a pena checar o application.properties, caso precise mudar as configurações do seu banco de dados e coisas de execução local (por exemplo, em qual porta quer rodar o projeto).

### 3 - Implementação de funcionalidades/itens

Como dito no ponto anterior, o projeto foi feito no modelo MVC. Ou seja, foram implementados:
* Classes Model e Repository para todas as entidades/tabelas do banco;
* Classes Controller e Service para as entidades, de acordo com a necessidade do projeto (todas elas, exceto "cargo", tem um Controller; "cargo" e "pessoa_salario_consolidado" possuem um Service);
* Um Service e um Controller extra, dedicados para o cálculo do salário.

A partir destas, o que foi pedido na atividade foi implementado, que é:
* Tela de ***Listagem de Pessoas*** utilizando JSP; e 
* Implementação do cálculo dos salários das pessoas da forma que foi pedido, com opção (através de um botão) na tela para recalcula-los.

Como componentes opcionais, foram implementados:
* Olhar último tópico do README;

Também foi implementado, por motivos pessoais:

* Endpoint para checar se a aplicação está funcionando bem;
* Tela para consulta individual de uma pessoa (baseada no ID);
* Tela que mostra a tabela de vencimento, mostrando melhor as regras de pagamento;
* Validação no caso de houver alguma "pessoa" com "cargo_id" inválido/nulo (campo 928);

---

## Execução em um ambiente local e pré-requisitos

É esperado que tenha JDK 17, Maven, Git e PostgreSQL em execução. Se não houver qualquer um destes, instale-os!

- - Verifique se o Java SDK está instalado - no cmd/terminal, execute o comando: 

```
java -version
```  

Exemplo de saída esperada do terminal: 

`java version "17.0.9" 2023-10-17 LTS`

- - Verifique se o Apache Maven está instalado - no cmd/terminal, execute o comando: 

```
mvn -v
``` 

Exemplo de saída esperada do terminal:
```
Apache Maven 3.9.6 (bc0240f3c744dd6b6ec2920b3cd08dcc295161ae)
Maven home: C:\bin\apache-maven-3.9.6
Java version: 17.0.9, vendor: Oracle Corporation, runtime: C:\Program Files\Java\jdk-17
Default locale: pt_BR, platform encoding: Cp1252
OS name: "windows 10", version: "10.0", arch: "amd64", family: "windows"
```




### Versão 1 (Caso utilize o Spring Tool Suite 4)

Se utilizar o STS (como eu), basta clonar o repositório e importar o projeto Maven (o pom.xml) e executa-lo como Spring Boot App no seu STS.

### Versão 2 (Casos generalizados)

#### Configurando...
* Clone o repositório do projeto do GitHub para o seu ambiente local usando o Git.
* Configurações do Banco de Dados - No arquivo application.properties ou application.yml do projeto Spring Boot, configure as propriedades de conexão com o banco de dados PostgreSQL, como URL, nome do banco de dados, nome de usuário e senha. Tem valores padrão no do projeto, talvez você queira muda-los.

#### Preparando o banco...
Utilize os arquivos no diretório "extras", em especial o script de criação e importação, para criar as tabelas na sua database do PostgreSQL - note que é pre-suposto que você tenha uma massa para inserir. Está disponibilizada, na pasta, a massa utilizada. 

#### Executando...
* Compilação

Navegue até o diretório raiz do projeto no terminal e execute o comando `mvn clean package` para compilar o projeto e gerar o arquivo JAR executável.

* Execução

Após a conclusão da compilação, navegue até o diretório target dentro do diretório do projeto e execute o comando `java -jar <nome_do_arquivo_jar>` para iniciar o aplicativo Spring Boot. Substitua <nome_do_arquivo_jar> pelo nome real do arquivo JAR gerado na sua máquina.

#### Acessando...

* Abra um navegador da web e acesse http://localhost:8090/ para ver a página de confirmação de execução e voilà: basta acessar os endpoints. Está sugerido a porta 8090 pois é a que está sendo utilizada no `application.properties`.
 

---

## Diferenciais opcionais FEITOS

● Criar um CRUD de Pessoa para atualizar, excluir e incluir novas pessoas.

## Diferenciais opcionais TO DO - podem vir em um futuro commit

● Utilizar processamento assíncrono no cálculo dos salários.

● Criar um relatório, utilizando JasperReports, para exibição das pessoas e seus
salários calculados e exportação em PDF.

● Criar um CRUD de usuário e implementar autenticação via Login e Senha.

● Criar testes de unidade.



