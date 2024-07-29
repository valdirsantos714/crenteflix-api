package com.valdirsantos714.crenteflix.model.conteudo;

public enum Categoria {

    FILME("filme"),
    SERIE("serie");

    private String nome;

    Categoria(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
