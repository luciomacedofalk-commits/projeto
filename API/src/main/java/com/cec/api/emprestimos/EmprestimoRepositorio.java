package com.cec.api.emprestimos;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmprestimoRepositorio extends JpaRepository<Emprestimo, Long> {

}