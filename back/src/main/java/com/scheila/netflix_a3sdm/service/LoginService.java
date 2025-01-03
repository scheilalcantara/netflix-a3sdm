package com.scheila.netflix_a3sdm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.scheila.netflix_a3sdm.model.Login;
import com.scheila.netflix_a3sdm.repository.LoginRepo;

@Service
public class LoginService {

    @Autowired
    private LoginRepo repository;
    private PasswordEncoder passwordEncoder;

    public LoginService(LoginRepo repository) {
        this.repository = repository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public List<Login> listarLogins() {
        List<Login> lista = (List<Login>) repository.findAll();
        return lista;
    }

    public Login editarLogin(Login login) {
        String encoder = this.passwordEncoder.encode(login.getSenha());
        login.setSenha(encoder);
        Login loginNovo = repository.save(login);
        return loginNovo;
    }

    public String validarLogin(Login login) {
        Login usuario = repository.findByEmail(login.getEmail());

        if(usuario == null) {
            return "Email não encontrado";

        }
        Boolean senhaValida = passwordEncoder.matches(login.getSenha(), usuario.getSenha());

        if(!senhaValida) {
            return "Senha incorreta";

        }
        
        return "Login válido";
    }
}