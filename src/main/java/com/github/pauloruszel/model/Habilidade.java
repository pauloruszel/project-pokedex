package com.github.pauloruszel.model;

import java.util.Objects;

public class Habilidade {

    private Long id;
    private String nomeHabilidade;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeHabilidade() {
        return nomeHabilidade;
    }

    public void setNomeHabilidade(String nomeHabilidade) {
        this.nomeHabilidade = nomeHabilidade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Habilidade that = (Habilidade) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(nomeHabilidade, that.nomeHabilidade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nomeHabilidade);
    }
}
