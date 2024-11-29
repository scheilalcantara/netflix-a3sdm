package com.scheila.netflix_a3sdm.service;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.scheila.netflix_a3sdm.model.Cadastro;

import com.scheila.netflix_a3sdm.repository.CadastroRepo;


@Service
public class CadastroService {

    private CadastroRepo repository;
    private PasswordEncoder passwordEncoder;

    public CadastroService(CadastroRepo repository) {
        this.repository = repository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public List<Cadastro> listarCadastro() {
        List<Cadastro> lista = (List<Cadastro>) repository.findAll();
        return lista;
    }

    public Cadastro criarCadastro(Cadastro cadastro) {
        String encoder = this.passwordEncoder.encode(cadastro.getSenha());
        cadastro.setSenha(encoder);
        Cadastro cadastroNovo = repository.save(cadastro);
        return cadastroNovo;

    }

    public Cadastro editarCadastro(Cadastro cadastro) {
        String encoder = this.passwordEncoder.encode(cadastro.getSenha());
        cadastro.setSenha(encoder);
        Cadastro cadastroNovo = repository.save(cadastro);
        return cadastroNovo;
    }

    public Boolean excluirCadastro(Integer id_usuario) {
        repository.deleteById(id_usuario);
        return true;
    }

    public Boolean validarSenha(Cadastro cadastro) {
        String senha = repository.getById(cadastro.getId_usuario()).getSenha();
        Boolean valid = passwordEncoder.matches(cadastro.getSenha(), senha);
        return valid;

    }

}