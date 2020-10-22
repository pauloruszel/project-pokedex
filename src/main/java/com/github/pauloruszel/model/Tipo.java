package com.github.pauloruszel.model;

import java.util.Objects;

public class Tipo {

    private Long id;
    private String nomeTipo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeTipo() {
        return nomeTipo;
    }

    public void setNomeTipo(String nomeTipo) {
        this.nomeTipo = nomeTipo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tipo tipo = (Tipo) o;
        return Objects.equals(id, tipo.id) &&
                Objects.equals(nomeTipo, tipo.nomeTipo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nomeTipo);
    }
}
