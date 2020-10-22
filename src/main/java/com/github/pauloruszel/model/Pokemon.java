package com.github.pauloruszel.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Pokemon {

    @Id
    private Long id;

    private String nomePokemon;
    private String altura;
    private String peso;
    private String genero;
    private String categoria;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomePokemon() {
        return nomePokemon;
    }

    public void setNomePokemon(String nomePokemon) {
        this.nomePokemon = nomePokemon;
    }

    public String getAltura() {
        return altura;
    }

    public void setAltura(String altura) {
        this.altura = altura;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pokemon pokemon = (Pokemon) o;
        return Objects.equals(id, pokemon.id) &&
                Objects.equals(nomePokemon, pokemon.nomePokemon) &&
                Objects.equals(altura, pokemon.altura) &&
                Objects.equals(peso, pokemon.peso) &&
                Objects.equals(genero, pokemon.genero) &&
                Objects.equals(categoria, pokemon.categoria);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nomePokemon, altura, peso, genero, categoria);
    }
}
