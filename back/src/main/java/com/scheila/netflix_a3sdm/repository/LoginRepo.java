package com.scheila.netflix_a3sdm.repository;

import org.springframework.data.repository.CrudRepository;

import com.scheila.netflix_a3sdm.model.Login;


public interface LoginRepo  extends CrudRepository<Login, Integer>{

    Login findByEmailAndSenha(String email, String senha);
    
    Login getById(int id_usuario);
}

