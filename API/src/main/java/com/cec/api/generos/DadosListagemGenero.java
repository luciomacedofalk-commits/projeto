package com.cec.api.generos;

import com.cec.api.generos.DadosListagemGenero;

public record DadosListagemGenero(Long id, String nome) {
    public DadosListagemGenero(Genero dados) {
        this(dados.getId(), dados.getNome());
    }
}
