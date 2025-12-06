package com.cec.api.livros;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "livro")
@Entity(name = "livros")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")

public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private int isbn;
    private String ano_publicacao;
    private Long id_genero;
    private Long id_autor;


    public Livro(DadosCadastroLivro dados) {
        this.titulo = dados.titulo();
        this.isbn = dados.isbn();
        this.ano_publicacao = dados.ano_publicacao();
        this.id_genero = dados.id_genero();
        this.id_autor = dados.id_autor();
    }

    public void atualizaInformacoesLivros(DadosAlteracaoLivro dados) {
        if (dados.titulo() != null) {
            this.titulo = dados.titulo();
        }
        if (dados.isbn() != 0) {
            this.isbn = dados.isbn();
        }
        if (dados.ano_publicacao() != null) {
            this.ano_publicacao = dados.ano_publicacao();
        }
        if (dados.id_genero() != 0) {
            this.id_genero = dados.id_genero();
        }
        if (dados.id_autor() != 0) {
            this.id_autor = dados.id_autor();
        }
    }

    public String getFoto() {
        return "";
    }
}
