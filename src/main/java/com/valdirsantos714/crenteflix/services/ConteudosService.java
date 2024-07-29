package com.valdirsantos714.crenteflix.services;

import com.valdirsantos714.crenteflix.model.conteudo.Conteudo;
import com.valdirsantos714.crenteflix.repositories.ConteudoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ConteudosService {

    @Autowired
    private ConteudoRepository repository;

    public Conteudo save(Conteudo conteudo) {
        return repository.save(conteudo);
    }

    public List<Conteudo> findAll() {
        return repository.findAll();
    }

    public Conteudo findById(Long id) {
        var conteudo = repository.findById(id).orElseThrow(() -> new RuntimeException("Erro! Conteudo não encontrado!"));

        return conteudo;

    }

    public Conteudo update(Long id, Conteudo conteudoNovo) {
        var conteudo = repository.findById(id).orElseThrow(() -> new RuntimeException("Erro! Conteudo não encontrado!"));

        conteudo.setCategoria(conteudoNovo.getCategoria());
        conteudo.setNome(conteudoNovo.getNome());
        conteudo.setDescricao(conteudoNovo.getDescricao());
        conteudo.setImgUrl(conteudoNovo.getImgUrl());
        conteudo.setDuracaoFilme(conteudoNovo.getDuracaoFilme());
        conteudo.setAnoLancamento(conteudoNovo.getAnoLancamento());
        conteudo.setLinkAssistir(conteudoNovo.getLinkAssistir());
        conteudo.setFavoritosList(conteudoNovo.getFavoritosList());
        repository.save(conteudo);

        return conteudo;
    }

    public void delete(Long id) {
        var conteudo = repository.findById(id).orElseThrow(() -> new RuntimeException("Erro! Conteudo não encontrado!"));

        repository.deleteById(id);
    }
}
