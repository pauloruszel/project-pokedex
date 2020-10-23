package com.github.pauloruszel.dto;

import java.io.Serializable;
import java.util.Objects;

public class FraquezaDTO implements Serializable {

    private static final long serialVersionUID = 246781674784450946L;

    private Long id;
    private String nomeFraqueza;
    private PokemonDTO pokemonDTO;

    public FraquezaDTO() {
    }

    public FraquezaDTO(Long id, String nomeFraqueza, PokemonDTO pokemonDTO) {
        this.id = id;
        this.nomeFraqueza = nomeFraqueza;
        this.pokemonDTO = pokemonDTO;
    }

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

    public PokemonDTO getPokemonDTO() {
        return pokemonDTO;
    }

    public void setPokemonDTO(PokemonDTO pokemonDTO) {
        this.pokemonDTO = pokemonDTO;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FraquezaDTO that = (FraquezaDTO) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(nomeFraqueza, that.nomeFraqueza) &&
                Objects.equals(pokemonDTO, that.pokemonDTO);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nomeFraqueza, pokemonDTO);
    }
}
