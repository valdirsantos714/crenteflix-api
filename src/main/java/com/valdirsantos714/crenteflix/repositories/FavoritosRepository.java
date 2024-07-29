package com.valdirsantos714.crenteflix.repositories;

import com.valdirsantos714.crenteflix.model.favoritos.Favoritos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavoritosRepository extends JpaRepository<Favoritos, Long> {
}
