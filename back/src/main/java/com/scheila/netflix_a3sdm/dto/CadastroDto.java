package com.scheila.netflix_a3sdm.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CadastroDto {
    private String email;
    private String username;
    private String senha;

    public CadastroDto(String email, String username, String senha){
        super();
        this.email = email;
        this.username = username;
        this.senha = senha;
    }
}
