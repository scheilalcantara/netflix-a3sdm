package com.scheila.netflix_a3sdm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scheila.netflix_a3sdm.model.Cadastro;

public interface CadastroRepo extends JpaRepository<Cadastro, Long> {
    Cadastro findByEmail(String email);         // Busca um usuário pelo email
    Cadastro findByUsername(String username);  // Busca um usuário pelo username
}
