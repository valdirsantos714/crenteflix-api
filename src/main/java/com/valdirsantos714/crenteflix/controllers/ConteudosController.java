package com.valdirsantos714.crenteflix.controllers;

import com.valdirsantos714.crenteflix.model.conteudo.Conteudo;
import com.valdirsantos714.crenteflix.payloads.conteudo.ConteudoRequestPayload;
import com.valdirsantos714.crenteflix.payloads.conteudo.ConteudoResponsePayload;
import com.valdirsantos714.crenteflix.services.ConteudosService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/conteudo")
@CrossOrigin("*")
public class ConteudosController {

    @Autowired
    private ConteudosService service;

    @GetMapping("/all")
    public ResponseEntity findAll() {
        var list = service.findAll();

        return ResponseEntity.ok(list.stream().map(ConteudoResponsePayload::new));
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable (name = "id") Long id) {
        var conteudo = service.findById(id);

        return ResponseEntity.ok(new ConteudoResponsePayload(conteudo));
    }

    @Operation(security = { @SecurityRequirement(name = "bearer-key") })
    @PostMapping
    public ResponseEntity save(@RequestBody @Valid ConteudoRequestPayload payload, UriComponentsBuilder builder) {
        var conteudo = new Conteudo(payload);
        var uri = builder.path("/conteudo/{id}").buildAndExpand(conteudo.getId()).toUri();
        service.save(conteudo);
        return ResponseEntity.created(uri).body(new ConteudoResponsePayload(conteudo));

    }

    @Operation(security = { @SecurityRequirement(name = "bearer-key") })
    @PutMapping("/{id}")
    public ResponseEntity update (@PathVariable Long id, @RequestBody @Valid ConteudoRequestPayload payload) {
        var conteudoNovo = new Conteudo(payload);
        service.update(id, conteudoNovo);

        return ResponseEntity.ok(new ConteudoResponsePayload(conteudoNovo));
    }

    @Operation(security = { @SecurityRequirement(name = "bearer-key") })
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        service.delete(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/filmes")
    public ResponseEntity verFilmes () {
        var list = service.findFilmes();

        return ResponseEntity.ok().body(list.stream().map(ConteudoResponsePayload::new));
    }

    @GetMapping("/series")
    public ResponseEntity verSeries () {
        var list = service.findSeries();

        return ResponseEntity.ok().body(list.stream().map(ConteudoResponsePayload::new));
    }

    @GetMapping("/find/{nomeConteudo}")
    public ResponseEntity findConteudoByName(@PathVariable (name = "nomeConteudo") String nomeConteudo) {
        var conteudo = service.findConteudoByName(nomeConteudo);

        return ResponseEntity.ok(conteudo.stream().map(ConteudoResponsePayload::new));
    }

    @GetMapping("/filmes/{nomeFilme}")
    public ResponseEntity findFilmeByName(@PathVariable (name = "nomeFilme") String nomeFilme) {
        var filmes = service.findFilmesByName(nomeFilme);

        return ResponseEntity.ok(filmes.stream().map(ConteudoResponsePayload::new));
    }

    @GetMapping("/series/{nomeSerie}")
    public ResponseEntity findSerieByName(@PathVariable (name = "nomeSerie") String nomeSerie) {
        var series = service.findSeriesByName(nomeSerie);

        return ResponseEntity.ok(series.stream().map(ConteudoResponsePayload::new));
    }
}
