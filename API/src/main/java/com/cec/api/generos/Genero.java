package com.cec.api.generos;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "genero")
@Entity(name = "generos")
@Getter


@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of ="id")
public class Genero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    public Genero(DadosCadastroGenero dados) {
        this.nome = dados.nome();
    }

    public void atualizaInformacoesGeneros(DadosAlteracaoGenero dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
    }
}
