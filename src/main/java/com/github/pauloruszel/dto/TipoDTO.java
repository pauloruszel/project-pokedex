package com.github.pauloruszel.dto;

import java.io.Serializable;
import java.util.Objects;

public class TipoDTO implements Serializable {

    private static final long serialVersionUID = 8256732936274107131L;

    private Long id;
    private String nomeTipo;
    private PokemonDTO pokemonDTO;

    public TipoDTO() {
    }

    public TipoDTO(Long id, String nomeTipo, PokemonDTO pokemonDTO) {
        this.id = id;
        this.nomeTipo = nomeTipo;
        this.pokemonDTO = pokemonDTO;
    }

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
        TipoDTO that = (TipoDTO) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(nomeTipo, that.nomeTipo) &&
                Objects.equals(pokemonDTO, that.pokemonDTO);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nomeTipo, pokemonDTO);
    }
}
