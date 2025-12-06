package com.cec.api.pessoas;

import com.cec.api.pessoas.DadosListagemPessoa;

public record DadosListagemPessoa(Long id, String nome, String email, String telefone) {
    public DadosListagemPessoa(Pessoa dados) {
        this(dados.getId(), dados.getNome(), dados.getEmail(), dados.getTelefone());
    }
}
