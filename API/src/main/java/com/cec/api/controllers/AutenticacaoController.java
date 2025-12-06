package com.cec.api.controllers;

import com.cec.api.seguranca.TokenService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    public AutenticacaoController(AuthenticationManager authenticationManager, TokenService tokenService) {
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
    }

    @PostMapping
    public ResponseEntity<?> autenticar(@RequestBody @Valid login credenciais) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(credenciais.getUsuario(), credenciais.getSenha());
        try {
            Authentication authentication = authenticationManager.authenticate(authenticationToken);
            String token = tokenService.gerarToken(authenticationToken.getName());
            return ResponseEntity.ok(new token(token,"Baerer "));
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Credenciais inválidas");
        }
    }
}
@Getter
@Setter
class login {
    private String usuario;
    private String senha;

}
@Getter
@Setter
@AllArgsConstructor
class token {
    private String token;
    private String tipo;
}
