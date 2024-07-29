package com.valdirsantos714.crenteflix.controllers;

import com.valdirsantos714.crenteflix.model.conteudo.Conteudo;
import com.valdirsantos714.crenteflix.payloads.conteudo.ConteudoRequestPayload;
import com.valdirsantos714.crenteflix.payloads.conteudo.ConteudoResponsePayload;
import com.valdirsantos714.crenteflix.services.ConteudosService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/conteudo")
public class ConteudosController {

    @Autowired
    private ConteudosService service;

    @GetMapping("/all")
    public ResponseEntity findAll() {
        var list = service.findAll();

        return ResponseEntity.ok(list.stream().map(ConteudoResponsePayload::new));
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id) {
        var conteudo = service.findById(id);

        return ResponseEntity.ok(new ConteudoResponsePayload(conteudo));
    }


    @PostMapping
    public ResponseEntity save(@RequestBody @Valid ConteudoRequestPayload payload, UriComponentsBuilder builder) {
        var conteudo = new Conteudo(payload);
        var uri = builder.path("/conteudo/{id}").buildAndExpand(conteudo.getId()).toUri();
        service.save(conteudo);
        return ResponseEntity.created(uri).body(new ConteudoResponsePayload(conteudo));

    }

    @PutMapping("/{id}")
    public ResponseEntity update (@PathVariable Long id, @RequestBody @Valid ConteudoRequestPayload payload) {
        var conteudoNovo = new Conteudo(payload);
        service.update(id, conteudoNovo);

        return ResponseEntity.ok(new ConteudoResponsePayload(conteudoNovo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        service.delete(id);

        return ResponseEntity.noContent().build();
    }
}
