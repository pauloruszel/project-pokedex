package com.github.pauloruszel.domain.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Habilidade extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idHabilidade", length = 4, precision = 10)
    private Long id;

    @Column(name = "nmHabilidade", length = 70)
    private String nomeHabilidade;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idPokemon")
    private Pokemon pokemon;

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
        Habilidade that = (Habilidade) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(nomeHabilidade, that.nomeHabilidade) &&
                Objects.equals(pokemon, that.pokemon);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nomeHabilidade, pokemon);
    }
}
