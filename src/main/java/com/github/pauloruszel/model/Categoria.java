package com.github.pauloruszel.model;

import java.util.Objects;

public class Categoria {

    private Long id;
    private String nomeCategoria;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Categoria categoria = (Categoria) o;
        return Objects.equals(id, categoria.id) &&
                Objects.equals(nomeCategoria, categoria.nomeCategoria);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nomeCategoria);
    }
}
