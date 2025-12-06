package com.cec.api.livros;

public record DadosListagemLivro(Long id, String titulo, int isbn, String ano_publicacao, Long id_genero, Long id_autor, String foto) {
    public DadosListagemLivro(Livro dados){
        this(dados.getId(), dados.getTitulo(), dados.getIsbn(), dados.getAno_publicacao(), dados.getId_genero(), dados.getId_autor(), dados.getFoto());

    }
}
