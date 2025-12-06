package com.cec.api.controllers;

import com.cec.api.livros.DadosAlteracaoLivro;
import com.cec.api.livros.DadosCadastroLivro;
import com.cec.api.livros.DadosListagemLivro;
import com.cec.api.livros.Livro;
import com.cec.api.livros.LivroRepositorio;
import com.cec.api.livros.DadosAlteracaoLivro;
import com.cec.api.livros.DadosCadastroLivro;
import com.cec.api.livros.Livro;
import com.cec.api.livros.LivroRepositorio;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping ("/livros")
public class LivroCotroller {
    @Autowired
    private LivroRepositorio livroRepositorio;

    @PostMapping("/inserir")
    @Transactional
    public ResponseEntity<?> inserir(@RequestBody DadosCadastroLivro dados) {
        Livro livro = livroRepositorio.save(new Livro(dados));
        Long id = livro.getId();
        URI uri = ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("/id")
                .buildAndExpand(id)
                .toUri();
        return ResponseEntity.created(uri).build();

    }

    @GetMapping("/listar")
    public ResponseEntity<?> listar() {
        var lista = livroRepositorio.findAll().stream().map(DadosListagemLivro::new).toList();
        return ResponseEntity.ok(lista);
    }

    @PutMapping("/alterar")
    @Transactional
    public ResponseEntity<?> alterar(@PathVariable Long id, @RequestBody DadosAlteracaoLivro dados){
        if (!livroRepositorio.existsById(dados.id())) {
            return ResponseEntity.notFound().build();
        }
        Livro livro = livroRepositorio.getReferenceById(dados.id());
        livro.atualizaInformacoesLivros(dados);
        return ResponseEntity.ok(dados);
    }


    @DeleteMapping("/excluir/{id}")
    @Transactional
    public ResponseEntity<?> excluir(@PathVariable Long id){
        if (!livroRepositorio.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        livroRepositorio.deleteById(id);
        return ResponseEntity.noContent().build();


    }
}
