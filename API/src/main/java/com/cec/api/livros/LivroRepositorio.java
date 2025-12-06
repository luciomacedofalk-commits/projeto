package com.cec.api.livros;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface LivroRepositorio extends JpaRepository<Livro, Long> {

}
