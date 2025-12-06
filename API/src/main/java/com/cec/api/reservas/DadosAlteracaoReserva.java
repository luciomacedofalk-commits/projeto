package com.cec.api.reservas;

public record DadosAlteracaoReserva(Long id, String data_reserva, String data_validade, Long livro_id, Long pessoa_id) {
}
