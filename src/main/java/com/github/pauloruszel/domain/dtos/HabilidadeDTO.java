package com.github.pauloruszel.domain.dtos;

public class HabilidadeDTO implements BaseDTO {

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

}
