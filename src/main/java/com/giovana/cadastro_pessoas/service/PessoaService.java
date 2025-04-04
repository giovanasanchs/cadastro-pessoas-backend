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

    public List<Pessoa> listarComFiltro(String nome, String cpf) {
        List<Pessoa> pessoas = repository.findAll();

        if (nome != null && !nome.isBlank()) {
            pessoas = pessoas.stream()
                    .filter(p -> p.getNome().toLowerCase().contains(nome.toLowerCase()))
                    .toList();
        }

        if (cpf != null && !cpf.isBlank()) {
            String cpfNumeros = cpf.replaceAll("\\D", "");
            pessoas = pessoas.stream()
                    .filter(p -> p.getCpf().replaceAll("\\D", "").contains(cpfNumeros))
                    .toList();
        }

        return pessoas;
    }

    public Optional<Pessoa> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public void excluir(Long id) {
        repository.deleteById(id);
    }
}