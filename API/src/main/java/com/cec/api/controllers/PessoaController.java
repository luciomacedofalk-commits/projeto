package com.cec.api.controllers;

import com.cec.api.pessoas.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaRepositorio pessoaRepositorio;

    // POST /pessoas → Criar pessoa
    @PostMapping
    @Transactional
    public ResponseEntity<?> inserir(@RequestBody DadosCadastroPessoa dados) {
        Pessoa pessoa = pessoaRepositorio.save(new Pessoa(dados));
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(pessoa.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    // GET /pessoas → Listar todas
    @GetMapping
    public ResponseEntity<?> listar() {
        var lista = pessoaRepositorio.findAll()
                .stream()
                .map(DadosListagemPessoa::new)
                .toList();
        return ResponseEntity.ok(lista);
    }

    // PUT /pessoas/{id} → Alterar pessoa
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<?> alterar(@PathVariable Long id, @RequestBody DadosAlteracaoPessoa dados) {
        if (!pessoaRepositorio.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        Pessoa pessoa = pessoaRepositorio.getReferenceById(id);
        pessoa.atualizaInformacoesPessoa(dados);
        return ResponseEntity.ok(new DadosListagemPessoa(pessoa));
    }

    // DELETE /pessoas/{id} → Excluir pessoa
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> excluir(@PathVariable Long id) {
        if (!pessoaRepositorio.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        pessoaRepositorio.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
