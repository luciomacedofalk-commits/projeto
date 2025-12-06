package com.cec.api.emprestimos;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "emprestimo")
@Entity(name = "emprestimos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of ="id")
public class Emprestimo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String data_emprestimo;
    private String data_devolucao;
    private Long pessoa_id;
    private Long livro_id;


    public Emprestimo(DadosCadastroEmprestimo dados) {
        this.data_emprestimo = dados.data_emprestimo();
        this.data_devolucao = dados.data_devolucao();
        this.pessoa_id = dados.pessoa_id();
        this.livro_id = dados.livro_id();
    }

    public void atualizaInformacoesEmprestimos(DadosAlteracaoEmprestimo dados) {
        if (dados.data_emprestimo() != null) {
            this.data_emprestimo = dados.data_emprestimo();
        }
        if (dados.data_devolucao() != null) {
            this.data_devolucao = dados.data_devolucao();
        }
        if (dados.pessoa_id() != 0) {
            this.pessoa_id = dados.pessoa_id();
        }
        if (dados.livro_id() != 0) {
            this.livro_id = dados.livro_id();
        }
    }
}