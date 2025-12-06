package com.cec.api.reservas;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReservaRepositorio extends JpaRepository<Reserva, Long> {

}