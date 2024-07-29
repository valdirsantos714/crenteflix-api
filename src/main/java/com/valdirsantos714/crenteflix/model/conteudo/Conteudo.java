package com.valdirsantos714.crenteflix.model.conteudo;

import com.valdirsantos714.crenteflix.model.favoritos.Favoritos;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "conteudo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Conteudo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    private String nome;
    private String imgUrl;
    private String descricao;
    private String linkAssistir;
    private Integer duracaoFilme;
    private Integer anoLancamento;
    private String faixaEtaria;

    @OneToMany(mappedBy = "conteudo")
    private List<Favoritos> favoritosList = new ArrayList<>();
}
