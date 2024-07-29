package com.valdirsantos714.crenteflix.payloads.conteudo;

import com.valdirsantos714.crenteflix.model.conteudo.Categoria;
import com.valdirsantos714.crenteflix.model.conteudo.Conteudo;

public record ConteudoResponsePayload(Long id,
                                      Categoria categoria, String nome,
                                      String imgUrl, String descricao,
                                      String linkAssistir, String duracaoFilme,
                                      Integer anoLancamento, String faixaEtaria) {
    public ConteudoResponsePayload(Conteudo c) {
        this(c.getId(), c.getCategoria(), c.getNome(), c.getImgUrl(), c.getDescricao(), c.getLinkAssistir(), c.getDuracaoFilme(), c.getAnoLancamento(), c.getFaixaEtaria());
    }
}
