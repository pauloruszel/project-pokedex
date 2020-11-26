package com.github.pauloruszel.domain.model;

import javax.persistence.*;

@Entity
public class Fraqueza extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idFraqueza", length = 4, precision = 10)
    private Long id;

    @Column(name = "nmFraqueza", length = 70)
    private String nomeFraqueza;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idPokemon")
    private Pokemon pokemon;

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

    public Pokemon getPokemon() {
        return pokemon;
    }

    public void setPokemon(Pokemon pokemon) {
        this.pokemon = pokemon;
    }

}
