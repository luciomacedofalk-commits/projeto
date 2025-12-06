package com.cec.api.livros;

public record DadosAlteracaoLivro(Long id, String titulo, int isbn, String ano_publicacao, Long id_genero, Long id_autor, String foto) {

}
