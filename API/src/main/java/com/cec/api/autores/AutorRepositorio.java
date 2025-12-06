package com.cec.api.autores;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface AutorRepositorio extends JpaRepository<Autor, Long> {
}
