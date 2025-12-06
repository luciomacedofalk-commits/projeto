CREATE TABLE Usuario(
    id INT AUTO_INCREMENT PRIMARY KEY,
    usuario VARCHAR(200),
    senha VARCHAR(200)
);
CREATE TABLE Autor(
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(200)
);

CREATE TABLE Genero(
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(200)
);
CREATE TABLE Pessoa(
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(200),
    email VARCHAR(200),
    telefone VARCHAR(200)
);
CREATE TABLE Livro(
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_genero INT ,
    id_autor INT ,
    titulo VARCHAR(200),
    isbn INT(200),
    ano_publicacao VARCHAR(200)
);
CREATE TABLE Emprestimo(
    id INT AUTO_INCREMENT PRIMARY KEY,
    pessoa_id INT,
    livro_id INT,
    data_emprestimo VARCHAR(200),
    data_devolucao VARCHAR(200),
    FOREIGN KEY (pessoa_id) REFERENCES pessoa(id),
    FOREIGN KEY (livro_id) REFERENCES livro(id)
);

CREATE TABLE Reserva(
    id INT AUTO_INCREMENT PRIMARY KEY,
    livro_id INT,
    pessoa_id INT,
    data_reserva VARCHAR(200),
    data_validade VARCHAR(200),
    FOREIGN KEY (livro_id) REFERENCES livro(id),
    FOREIGN KEY (pessoa_id) REFERENCES pessoa(id)
);