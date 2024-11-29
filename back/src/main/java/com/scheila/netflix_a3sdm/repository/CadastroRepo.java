package com.scheila.netflix_a3sdm.repository;

import org.springframework.data.repository.CrudRepository;

import com.scheila.netflix_a3sdm.model.Cadastro;

public interface CadastroRepo  extends CrudRepository<Cadastro, Integer>{

    Cadastro getById(int id_usuario);

}
