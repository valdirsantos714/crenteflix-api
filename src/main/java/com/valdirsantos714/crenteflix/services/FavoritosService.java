package com.valdirsantos714.crenteflix.services;

import com.valdirsantos714.crenteflix.model.favoritos.Favoritos;
import com.valdirsantos714.crenteflix.repositories.FavoritosRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class FavoritosService {

    @Autowired
    private FavoritosRepository repository;

    public Favoritos save(Favoritos favoritos) {
        var user = favoritos.getUser();

        return repository.save(favoritos);
    }
}
