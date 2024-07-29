package com.valdirsantos714.crenteflix.payloads.auth;

import com.valdirsantos714.crenteflix.model.security.UserRole;
import com.valdirsantos714.crenteflix.model.security.Users;

public record DadosAdmin(Long id, String login, String senha, UserRole
        role) {
    public DadosAdmin(Users user) {
        this(user.getId(), user.getLogin(), user.getSenha(), user.getRole());
    }
}
