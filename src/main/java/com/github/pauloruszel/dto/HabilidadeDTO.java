package com.github.pauloruszel.dto;

import java.io.Serializable;
import java.util.Objects;

public class HabilidadeDTO implements Serializable {

    private static final long serialVersionUID = -434235694455846496L;

    private Long id;
    private String nomeHabilidade;
    private PokemonDTO pokemonDTO;

    public HabilidadeDTO() {
    }

    public HabilidadeDTO(Long id, String nomeHabilidade, PokemonDTO pokemonDTO) {
        this.id = id;
        this.nomeHabilidade = nomeHabilidade;
        this.pokemonDTO = pokemonDTO;
    }

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
        HabilidadeDTO that = (HabilidadeDTO) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(nomeHabilidade, that.nomeHabilidade) &&
                Objects.equals(pokemonDTO, that.pokemonDTO);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nomeHabilidade, pokemonDTO);
    }
}
