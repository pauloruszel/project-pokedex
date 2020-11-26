package com.github.pauloruszel.domain.dtos;

public class FraquezaDTO implements BaseDTO {

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

}
