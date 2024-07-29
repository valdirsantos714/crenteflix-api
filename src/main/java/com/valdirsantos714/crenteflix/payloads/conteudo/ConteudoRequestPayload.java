package com.valdirsantos714.crenteflix.payloads.conteudo;

import com.valdirsantos714.crenteflix.model.conteudo.Categoria;
import com.valdirsantos714.crenteflix.model.conteudo.Conteudo;
import jakarta.validation.constraints.NotNull;

public record ConteudoRequestPayload(@NotNull(message = "Não pode deixar a categoria null") Categoria categoria, @NotNull(message = "Não pode deixar o nome null") String nome,
                                     @NotNull(message = "Não pode deixar o link da imagem null") String imgUrl, String descricao,
                                     @NotNull(message = "Não pode deixar o link de assistir null") String linkAssistir, String duracaoFilme,
                                     Integer anoLancamento, String faixaEtaria) {
    public ConteudoRequestPayload (Conteudo c) {
        this(c.getCategoria(), c.getNome(), c.getImgUrl(), c.getDescricao(), c.getLinkAssistir(), c.getDuracaoFilme(), c.getAnoLancamento(), c.getFaixaEtaria());
    }
}
