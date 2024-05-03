SET datestyle = 'ISO, DMY';

CREATE TABLE pessoa (
    ID SERIAL PRIMARY KEY,
    Nome VARCHAR(100),
    Cidade VARCHAR(100),
    Email VARCHAR(100),
    CEP VARCHAR(10),
    Endereco VARCHAR(255),
    Pais VARCHAR(50),
    Usuario VARCHAR(20),
    Telefone VARCHAR(15),
    Data_Nascimento DATE,
    Cargo_ID INT
);

CREATE TABLE cargo (
    ID SERIAL PRIMARY KEY,
    nome VARCHAR(20)
);

CREATE TABLE vencimentos (
    ID SERIAL PRIMARY KEY,
    Descricao VARCHAR(100),
    Valor NUMERIC,
    Tipo VARCHAR(50)
);

CREATE TABLE cargo_vencimentos (
    ID SERIAL PRIMARY KEY,
    Cargo_ID INT,
    Vencimento_ID INT,
    FOREIGN KEY (Cargo_ID) REFERENCES cargo(ID),
    FOREIGN KEY (Vencimento_ID) REFERENCES vencimentos(ID)
);

COPY pessoa FROM 'C:\path\do\csv\pessoa.csv' DELIMITER ';' CSV HEADER;
COPY cargo FROM 'C:\path\do\csv\cargo.csv' DELIMITER ';' CSV HEADER;
COPY vencimentos FROM 'C:\path\do\csv\vencimentos.csv' DELIMITER ';' CSV HEADER;
COPY cargo_vencimentos FROM 'C:\path\do\csv\cargo_vencimentos.csv' DELIMITER ';' CSV HEADER;

CREATE TABLE pessoa_salario_consolidado (
    pessoa_id SERIAL PRIMARY KEY,
    nome_pessoa VARCHAR(100),
    nome_cargo VARCHAR(100),
    salario NUMERIC
);
