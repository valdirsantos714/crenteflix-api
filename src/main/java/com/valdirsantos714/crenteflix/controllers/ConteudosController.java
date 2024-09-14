package com.valdirsantos714.crenteflix.controllers;

import com.valdirsantos714.crenteflix.model.conteudo.Conteudo;
import com.valdirsantos714.crenteflix.payloads.conteudo.ConteudoRequestPayload;
import com.valdirsantos714.crenteflix.payloads.conteudo.ConteudoResponsePayload;
import com.valdirsantos714.crenteflix.services.ConteudosService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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

    @Operation(summary = "Retorna lista com todos os conteúdos",  responses = {
            @ApiResponse(description = "Requisição feita com sucesso", responseCode = "200"),
            @ApiResponse(responseCode = "404", description = "Conteúdos não encontrados"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    @GetMapping("/all")
    public ResponseEntity findAll() {
        var list = service.findAll();

        return ResponseEntity.ok(list.stream().map(ConteudoResponsePayload::new));
    }

    @Operation(summary = "Retorna conteúdo pelo id",  responses = {
            @ApiResponse(description = "Requisição feita com sucesso", responseCode = "200"),
            @ApiResponse(responseCode = "404", description = "Conteúdos não encontrados"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable (name = "id") Long id) {
        var conteudo = service.findById(id);

        return ResponseEntity.ok(new ConteudoResponsePayload(conteudo));
    }

    @Operation(security = { @SecurityRequirement(name = "bearer-key") },
            summary = "Salva conteúdo",  responses = {
            @ApiResponse(description = "Requisição feita com sucesso", responseCode = "201"),
            @ApiResponse(responseCode = "401", description = "Erro de autenticação"),
            @ApiResponse(responseCode = "403", description = "Requisição não autorizada"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    @PostMapping
    public ResponseEntity save(@RequestBody @Valid ConteudoRequestPayload payload, UriComponentsBuilder builder) {
        var conteudo = new Conteudo(payload);
        var uri = builder.path("/conteudo/{id}").buildAndExpand(conteudo.getId()).toUri();
        service.save(conteudo);
        return ResponseEntity.created(uri).body(new ConteudoResponsePayload(conteudo));

    }


    @Operation(security = { @SecurityRequirement(name = "bearer-key") },
            summary = "Atualiza conteúdo pelo id",  responses = {
            @ApiResponse(description = "Requisição feita com sucesso", responseCode = "200"),
            @ApiResponse(responseCode = "401", description = "Erro de autenticação"),
            @ApiResponse(responseCode = "403", description = "Requisição não autorizada"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    @PutMapping("/{id}")
    public ResponseEntity update (@PathVariable Long id, @RequestBody @Valid ConteudoRequestPayload payload) {
        var conteudoNovo = new Conteudo(payload);
        service.update(id, conteudoNovo);

        return ResponseEntity.ok(new ConteudoResponsePayload(conteudoNovo));
    }

    @Operation(security = { @SecurityRequirement(name = "bearer-key") },
            summary = "Deleta conteúdo",  responses = {
            @ApiResponse(description = "Requisição feita com sucesso", responseCode = "204"),
            @ApiResponse(responseCode = "401", description = "Erro de autenticação"),
            @ApiResponse(responseCode = "403", description = "Requisição não autorizada"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        service.delete(id);

        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Retorna lista de filmes",  responses = {
            @ApiResponse(description = "Requisição feita com sucesso", responseCode = "200"),
            @ApiResponse(responseCode = "404", description = "Conteúdos não encontrados"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    @GetMapping("/filmes")
    public ResponseEntity verFilmes () {
        var list = service.findFilmes();

        return ResponseEntity.ok().body(list.stream().map(ConteudoResponsePayload::new));
    }

    @Operation(summary = "Retorna lista de séries",  responses = {
            @ApiResponse(description = "Requisição feita com sucesso", responseCode = "200"),
            @ApiResponse(responseCode = "404", description = "Conteúdos não encontrados"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    @GetMapping("/series")
    public ResponseEntity verSeries () {
        var list = service.findSeries();

        return ResponseEntity.ok().body(list.stream().map(ConteudoResponsePayload::new));
    }


    @Operation(summary = "Faz pesquisa de conteúdos pelo nome",  responses = {
            @ApiResponse(description = "Requisição feita com sucesso", responseCode = "200"),
            @ApiResponse(responseCode = "404", description = "Conteúdos não encontrados"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    @GetMapping("/find/{nomeConteudo}")
    public ResponseEntity findConteudoByName(@PathVariable (name = "nomeConteudo") String nomeConteudo) {
        var conteudo = service.findConteudoByName(nomeConteudo);

        return ResponseEntity.ok(conteudo.stream().map(ConteudoResponsePayload::new));
    }

    @Operation(summary = "Faz pesquisa de filmes pelo nome",  responses = {
        @ApiResponse(description = "Requisição feita com sucesso", responseCode = "200"),
        @ApiResponse(responseCode = "404", description = "Conteúdos não encontrados"),
        @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    @GetMapping("/filmes/{nomeFilme}")
    public ResponseEntity findFilmeByName(@PathVariable (name = "nomeFilme") String nomeFilme) {
        var filmes = service.findFilmesByName(nomeFilme);

        return ResponseEntity.ok(filmes.stream().map(ConteudoResponsePayload::new));
    }

    @Operation(summary = "Faz pesquisa de séries pelo nome",  responses = {
            @ApiResponse(description = "Requisição feita com sucesso", responseCode = "200"),
            @ApiResponse(responseCode = "404", description = "Conteúdos não encontrados"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    @GetMapping("/series/{nomeSerie}")
    public ResponseEntity findSerieByName(@PathVariable (name = "nomeSerie") String nomeSerie) {
        var series = service.findSeriesByName(nomeSerie);

        return ResponseEntity.ok(series.stream().map(ConteudoResponsePayload::new));
    }
}
