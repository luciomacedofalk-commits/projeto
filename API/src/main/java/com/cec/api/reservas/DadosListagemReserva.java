package com.cec.api.reservas;

public record DadosListagemReserva(Long id, String data_reserva, String data_validade, Long livro_id, Long pessoa_id) {
    public DadosListagemReserva(Reserva dados) {
        this(dados.getId(), dados.getData_reserva(), dados.getData_validade(), dados.getLivro_id(), dados.getPessoa_id());
    }
}
