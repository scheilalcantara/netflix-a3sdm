package com.scheila.netflix_a3sdm.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scheila.netflix_a3sdm.model.Cadastro;
import com.scheila.netflix_a3sdm.repository.CadastroRepo;


@Service
public class CadastroService {

    @Autowired
    private CadastroRepo cadastroRepository;

    public Cadastro registrarUsuario(Cadastro cadastro) throws Exception {
        // Verifica se o email já está cadastrado
        if (cadastroRepository.findByEmail(cadastro.getEmail()) != null) {
            throw new Exception("Email já está em uso.");
        }

        // Verifica se o username já está cadastrado
        if (cadastroRepository.findByUsername(cadastro.getUsername()) != null) {
            throw new Exception("Username já está em uso.");
        }

        // Salva o usuário
        return cadastroRepository.save(cadastro);
    }
}
