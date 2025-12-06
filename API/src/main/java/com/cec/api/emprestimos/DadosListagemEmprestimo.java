package com.cec.api.emprestimos;

public record DadosListagemEmprestimo(Long id, String data_emprestimo, String data_devolucao, Long pessoa_id, Long livro_id) {
    public DadosListagemEmprestimo(Emprestimo dados) {
        this(dados.getId(), dados.getData_emprestimo(), dados.getData_devolucao(), dados.getPessoa_id(), dados.getLivro_id());
    }
}
