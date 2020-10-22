package com.github.pauloruszel.model;

import java.util.Objects;

public class Fraqueza {

    private Long id;
    private String nomeFraqueza;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeFraqueza() {
        return nomeFraqueza;
    }

    public void setNomeFraqueza(String nomeFraqueza) {
        this.nomeFraqueza = nomeFraqueza;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fraqueza fraqueza = (Fraqueza) o;
        return Objects.equals(id, fraqueza.id) &&
                Objects.equals(nomeFraqueza, fraqueza.nomeFraqueza);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nomeFraqueza);
    }
}
