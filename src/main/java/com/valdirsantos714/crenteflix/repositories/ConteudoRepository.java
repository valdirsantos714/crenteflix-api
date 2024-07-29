package com.valdirsantos714.crenteflix.repositories;

import com.valdirsantos714.crenteflix.model.conteudo.Conteudo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConteudoRepository extends JpaRepository<Conteudo, Long> {
}
