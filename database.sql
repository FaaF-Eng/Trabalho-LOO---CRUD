CREATE DATABASE cadastro;

USE cadastro;

CREATE TABLE clientes (
  id INT PRIMARY KEY AUTO_INCREMENT,
  nome VARCHAR(100),
  documento VARCHAR(20),
  email VARCHAR(100)
);