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

### 3 - Implementação de funcionalidades/itens

Como dito no ponto anterior, o projeto foi feito no modelo MVC. Ou seja, foram implementados:
* Classes Model e Repository para todas as entidades/tabelas do banco;
* Classes Controller e Service para as entidades, de acordo com a necessidade do projeto (todas elas, exceto "cargo", tem um Controller; "cargo" e "pessoa_salario_consolidado" possuem um Service);
* Um Service e um Controller extra, dedicados para o cálculo do salário.

A partir destas, o que foi pedido na atividade foi implementado, que é:
* Tela de ***Listagem de Pessoas*** utilizando JSP; e 
* Implementação do cálculo dos salários das pessoas da forma que foi pedido, com opção (através de um botão) na tela para recalcula-los.

Como componentes opcionais, foram implementas:
* TBD, olhar último tópico do README;

Também foi implementado, por motivos pessoais:

* Tela para consulta individual de uma pessoa (baseada no ID);
* Tela que mostra a tabela de vencimento, mostrando melhor as regras de pagamento;
* Validação no caso de houver alguma "pessoa" com "cargo_id" inválido/nulo (campo 928);

---

## Execução em um ambiente local e pré-requisitos.

É esperado que tenha Java 17, Maven e PostgreSQL.

* Versão 1 (Caso utilize o Spring Tool Suite 4)

Se utilizar o STS (como eu), basta importar o projeto Maven e executa-lo como Spring Boot App.

* Versão 2 (Casos generalizados)

[PARA REDIGIR]

Abra o projeto em qualquer IDE com suporte ao Java (Eclipse, Netbeans, VSCode com as extensões necessárias) e execute-o diretamente lá. 

---

## Diferenciais opcionais - podem vir em um futuro commit

● Utilizar processamento assíncrono no cálculo dos salários.

● Criar um relatório, utilizando JasperReports, para exibição das pessoas e seus
salários calculados e exportação em PDF.

● Criar um CRUD de Pessoa para atualizar, excluir e incluir novas pessoas.

● Criar um CRUD de usuário e implementar autenticação via Login e Senha.

● Criar testes de unidade.



