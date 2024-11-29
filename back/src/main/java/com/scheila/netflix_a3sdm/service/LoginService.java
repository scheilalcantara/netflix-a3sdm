package com.scheila.netflix_a3sdm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scheila.netflix_a3sdm.model.Login;
import com.scheila.netflix_a3sdm.repository.LoginRepo;

@Service
public class LoginService {

    @Autowired
    private LoginRepo loginRepository;

    public boolean validarLogin(String username, String senha) {
        // Busca o login com base no username e senha
        Login login = loginRepository.findByUsernameAndSenha(username, senha);

        // Caso o login seja válido
        return login != null;
    }
}