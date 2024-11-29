package com.scheila.netflix_a3sdm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.scheila.netflix_a3sdm.model.Cadastro;
import com.scheila.netflix_a3sdm.repository.CadastroRepo;


@Service
public class CadastroService {

    private CadastroRepo repository;

    public CadastroService(CadastroRepo repository) {
        this.repository = repository;
    }

    public List<Cadastro> listarCadastro() {
        List<Cadastro> lista = (List<Cadastro>) repository.findAll();
        return lista;
    }

    public Cadastro criarCadastro(Cadastro cadastro) {
        Cadastro cadastroNovo = repository.save(cadastro);
        return cadastroNovo;

    }

    public Cadastro editarCadastro(Cadastro cadastro) {
        Cadastro cadastroNovo = repository.save(cadastro);
        return cadastroNovo;
    }

    public Boolean excluirCadastro(Integer id) {
        repository.deleteById(id);
        return true;
    }
}
