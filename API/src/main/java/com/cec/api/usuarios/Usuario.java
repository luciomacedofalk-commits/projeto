package com.cec.api.usuarios;

import com.cec.api.pessoas.DadosAlteracaoPessoa;
import com.cec.api.pessoas.DadosCadastroPessoa;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "usuario")
@Entity(name = "usuarios")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of ="id")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String usuario;
    private String senha;


}

