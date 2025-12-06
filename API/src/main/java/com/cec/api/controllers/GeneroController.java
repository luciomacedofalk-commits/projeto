package com.cec.api.controllers;

import com.cec.api.generos.*;
import com.cec.api.pessoas.DadosAlteracaoPessoa;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/generos")
public class GeneroController {
    @Autowired
    private GeneroRepositorio generoRepositorio;

    @PostMapping("/inserir")
    @Transactional
    public ResponseEntity<?> inserir(@RequestBody DadosCadastroGenero dados) {
        Genero genero = generoRepositorio.save(new Genero(dados));
        Long id = genero.getId();
        URI uri = ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("/id")
                .buildAndExpand(id)
                .toUri();
        return ResponseEntity.created(uri).build();

    }

    @GetMapping("/listar")
    public ResponseEntity<?> listar() {
        var lista = generoRepositorio.findAll().stream().map(DadosListagemGenero::new).toList();
        return ResponseEntity.ok(lista);
    }

    @PutMapping("/alterar")
    @Transactional
    public ResponseEntity<?> alterar(@PathVariable Long id, @RequestBody DadosAlteracaoGenero dados){
        if (!generoRepositorio.existsById(dados.id())) {
            return ResponseEntity.notFound().build();
        }
        Genero genero = generoRepositorio.getReferenceById(dados.id());
        genero.atualizaInformacoesGeneros(dados);
        return ResponseEntity.ok(dados);
    }


    @DeleteMapping("/excluir/{id}")
    @Transactional
    public ResponseEntity<?> excluir(@PathVariable Long id){
        if (!generoRepositorio.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        generoRepositorio.deleteById(id);
        return ResponseEntity.noContent().build();


    }
}