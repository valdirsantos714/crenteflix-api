package com.valdirsantos714.crenteflix.services;

import com.valdirsantos714.crenteflix.model.conteudo.Categoria;
import com.valdirsantos714.crenteflix.model.conteudo.Conteudo;
import com.valdirsantos714.crenteflix.repositories.ConteudoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
        repository.save(conteudo);

        return conteudo;
    }

    public void delete(Long id) {
        var conteudo = repository.findById(id).orElseThrow(() -> new RuntimeException("Erro! Conteudo não encontrado!"));

        repository.deleteById(id);
    }

    public List<Conteudo> findFilmes() {
        var list = findAll().stream().filter((l) -> l.getCategoria() == Categoria.FILME).collect(Collectors.toList());

        return list;
    }

    public List<Conteudo> findSeries() {
        var list = findAll().stream().filter((l) -> l.getCategoria() == Categoria.SERIE).collect(Collectors.toList());

        return list;
    }

    public List<Conteudo> findFilmesByName(String name) {
        var filmes = findFilmes().stream().filter((f) -> f.getNome().toLowerCase().startsWith(name.toLowerCase())).collect(Collectors.toList());

        return filmes;
    }

    public List<Conteudo> findSeriesByName(String name) {
        var series = findSeries().stream().filter((s) -> s.getNome().toLowerCase().startsWith(name.toLowerCase())).collect(Collectors.toList());

        return series;
    }

    //Pesquisa na lista de séries e de filmes
    public List<Conteudo> findConteudoByName(String name) {
        var conteudo = findAll().stream().filter((c) -> c.getNome().toLowerCase().startsWith(name.toLowerCase())).collect(Collectors.toList());

        return conteudo;
    }

}
