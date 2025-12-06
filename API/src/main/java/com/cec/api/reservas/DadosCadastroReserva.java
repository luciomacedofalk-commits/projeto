package com.cec.api.reservas;

public record DadosCadastroReserva(Long id, String data_reserva, String data_validade, Long livro_id, Long pessoa_id) {
}
