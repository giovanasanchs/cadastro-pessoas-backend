package com.giovana.cadastro_pessoas.controller;

import com.giovana.cadastro_pessoas.model.Pessoa;
import com.giovana.cadastro_pessoas.service.PessoaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {
    @Autowired
    private PessoaService service;

    @PostMapping
    public ResponseEntity<Pessoa> criar(@RequestBody @Valid Pessoa pessoa) {
        return ResponseEntity.ok(service.salvar(pessoa));
    }

    @GetMapping
    public List<Pessoa> listar(
            @RequestParam(required = false) String nome,
            @RequestParam(required = false) String cpf
    ) {
        return service.listarComFiltro(nome, cpf);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> buscar(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pessoa> atualizar(@PathVariable Long id, @RequestBody @Valid Pessoa pessoa) {
        if (!service.buscarPorId(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        pessoa.setId(id);
        return ResponseEntity.ok(service.salvar(pessoa));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
