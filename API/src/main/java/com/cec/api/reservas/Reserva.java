package com.cec.api.reservas;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "reserva")
@Entity(name = "reservas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of ="id")
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String data_reserva;
    private String data_validade;
    private Long livro_id;
    private Long pessoa_id;

    public Reserva(DadosCadastroReserva dados) {
        this.data_reserva = dados.data_reserva();
        this.data_validade = dados.data_validade();
        this.pessoa_id = dados.pessoa_id();
        this.livro_id = dados.livro_id();
    }

    public void atualizaInformcoesReservas(DadosAlteracaoReserva dados) {
        if (dados.data_reserva() != null) {
            this.data_reserva = dados.data_reserva();
        }
        if (dados.data_validade() != null) {
            this.data_validade = dados.data_validade();
        }
        if (dados.pessoa_id() != 0) {
            this.pessoa_id = dados.pessoa_id();
        }
        if (dados.livro_id() != 0) {
            this.livro_id = dados.livro_id();
        }
    }
}
