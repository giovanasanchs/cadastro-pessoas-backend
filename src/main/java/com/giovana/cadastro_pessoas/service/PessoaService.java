package com.giovana.cadastro_pessoas.service;

import com.giovana.cadastro_pessoas.model.Pessoa;
import com.giovana.cadastro_pessoas.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {
    @Autowired
    private PessoaRepository repository;

    public Pessoa salvar(Pessoa pessoa) {
        return repository.save(pessoa);
    }

    public List<Pessoa> listar() {
        return repository.findAll();
    }

    public Optional<Pessoa> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public void excluir(Long id) {
        repository.deleteById(id);
    }
}