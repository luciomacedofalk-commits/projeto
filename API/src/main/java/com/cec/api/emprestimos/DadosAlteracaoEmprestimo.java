package com.cec.api.emprestimos;

public record DadosAlteracaoEmprestimo(Long id, String data_emprestimo, String data_devolucao, Long pessoa_id, Long livro_id) {
}
