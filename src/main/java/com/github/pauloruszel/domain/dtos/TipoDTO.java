package com.github.pauloruszel.domain.dtos;

public class TipoDTO implements BaseDTO {

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

}
