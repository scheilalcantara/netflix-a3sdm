package com.scheila.netflix_a3sdm.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.scheila.netflix_a3sdm.model.Login;

public interface LoginRepo extends CrudRepository<Login, Integer> {

    Login findByEmail(String email);

    Login getById(int id_usuario);

    @Query(value = "select * from usuario where email = :email and senha = :senha", nativeQuery = true)
    public Login Login(String email, String senha);
}
