package com.scheila.netflix_a3sdm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scheila.netflix_a3sdm.model.Amigos;
import com.scheila.netflix_a3sdm.repository.AmigosRepo;

@Service
public class AmigosService {

    @Autowired
    private AmigosRepo repository;

    public AmigosService(AmigosRepo repository) {
        this.repository = repository;
    }

    public List<Amigos> listarAmigos() {
        List<Amigos> lista = (List<Amigos>) repository.findAll();
        return lista;
    }

    public Amigos criarAmigos(Amigos amigo) {
        Amigos amigoNovo = repository.save(amigo);
        return amigoNovo;

    }

    public Amigos editarAmigos(Amigos amigo) {
        Amigos amigoNovo = repository.save(amigo);
        return amigoNovo;
    }

    public Boolean excluirAmigos(Integer id) {
        repository.deleteById(id);
        return true;
    }
}
