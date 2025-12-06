package com.cec.api.pessoas;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "pessoa")
@Entity(name = "pessoas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of ="id")
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;


    public Pessoa(DadosCadastroPessoa dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
    }

    public void atualizaInformacoesPessoa(DadosAlteracaoPessoa dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
            this.email = dados.email();
            this.telefone = dados.telefone();
        }
    }


    }

