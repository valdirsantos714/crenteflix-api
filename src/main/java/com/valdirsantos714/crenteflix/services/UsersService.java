package com.valdirsantos714.crenteflix.services;

import com.valdirsantos714.crenteflix.model.security.Users;
import com.valdirsantos714.crenteflix.repositories.UsersRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class UsersService {

    @Autowired
    private UsersRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Users save(Users users) {
        users.setSenha(passwordEncoder.encode(users.getSenha())); //Transforma a senha que digitar em BCrypt
        return repository.save(users);
    }

    public List<Users> findAll() {
        return repository.findAll();
    }
}
