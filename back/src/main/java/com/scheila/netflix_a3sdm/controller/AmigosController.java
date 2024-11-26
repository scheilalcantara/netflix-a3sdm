package com.scheila.netflix_a3sdm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scheila.netflix_a3sdm.DAO.IAmigos;
import com.scheila.netflix_a3sdm.model.Amigos;


@RestController
public class AmigosController {

    @Autowired
    private IAmigos dao;

    @GetMapping("/amigos")
    public List<Amigos> listaAmigos() {
        return (List<Amigos>) dao.findAll();
    }

}
