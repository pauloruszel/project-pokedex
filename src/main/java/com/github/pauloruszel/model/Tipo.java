package com.github.pauloruszel.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

public class Tipo extends PanacheEntityBase implements Serializable {

    private static final long serialVersionUID = 3419642924389947466L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTipo", length = 4, precision = 10)
    private Long id;

    @Column(name = "nmTipo", length = 70)
    private String nomeTipo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idPokemon")
    private Pokemon pokemon;

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

    public Pokemon getPokemon() {
        return pokemon;
    }

    public void setPokemon(Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tipo tipo = (Tipo) o;
        return Objects.equals(id, tipo.id) &&
                Objects.equals(nomeTipo, tipo.nomeTipo) &&
                Objects.equals(pokemon, tipo.pokemon);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nomeTipo, pokemon);
    }
}
