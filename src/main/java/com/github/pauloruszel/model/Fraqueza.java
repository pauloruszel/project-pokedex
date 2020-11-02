package com.github.pauloruszel.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Fraqueza extends PanacheEntityBase implements Serializable {

    private static final long serialVersionUID = -5271505840505284882L;

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
