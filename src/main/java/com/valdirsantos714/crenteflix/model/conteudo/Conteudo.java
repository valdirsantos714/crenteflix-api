package com.valdirsantos714.crenteflix.model.conteudo;

import com.valdirsantos714.crenteflix.model.favoritos.Favoritos;
import com.valdirsantos714.crenteflix.payloads.conteudo.ConteudoRequestPayload;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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

    private String nome;
    private String imgUrl;
    private String descricao;
    private String linkAssistir;
    private String duracaoFilme;
    private Integer anoLancamento;
    private String faixaEtaria;

    @OneToMany(mappedBy = "conteudo")
    private List<Favoritos> favoritosList = new ArrayList<>();

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
