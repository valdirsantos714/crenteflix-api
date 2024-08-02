package com.valdirsantos714.crenteflix.model.conteudo;

import com.valdirsantos714.crenteflix.payloads.conteudo.ConteudoRequestPayload;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "conteudo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Conteudo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    @Column(unique = true)
    private String nome;
    private String imgUrl;

    @Column(columnDefinition = "text")
    private String descricao;
    private String linkAssistir;
    private String duracaoFilme;
    private Integer anoLancamento;
    private String faixaEtaria;

    public Conteudo(ConteudoRequestPayload payload) {
        this.categoria = payload.categoria();
        this.nome = payload.nome();
        this.imgUrl = payload.imgUrl();
        this.descricao = payload.descricao();
        this.linkAssistir = payload.linkAssistir();
        this.duracaoFilme = payload.duracaoFilme();
        this.anoLancamento = payload.anoLancamento();
        this.faixaEtaria = payload.faixaEtaria();
    }
}
