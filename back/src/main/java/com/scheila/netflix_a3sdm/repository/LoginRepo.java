package com.scheila.netflix_a3sdm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scheila.netflix_a3sdm.model.Login;

public interface LoginRepo extends JpaRepository<Login, Long> {
    Login findByEmailAndSenha(String email, String senha); // Busca por e-mail e a senha

    public Login findByUsernameAndSenha(String username, String senha);
}

