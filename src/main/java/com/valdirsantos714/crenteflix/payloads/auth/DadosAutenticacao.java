package com.valdirsantos714.crenteflix.payloads.auth;

import com.valdirsantos714.crenteflix.model.security.UserRole;
import com.valdirsantos714.crenteflix.model.security.Users;

public record DadosAutenticacao(String login, String senha, UserRole role) {
    public DadosAutenticacao(Users u) {
        this(u.getLogin(), u.getSenha(), u.getRole());
    }
}
