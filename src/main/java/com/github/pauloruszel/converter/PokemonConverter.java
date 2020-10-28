package com.github.pauloruszel.converter;

import com.github.pauloruszel.dto.PokemonDTO;
import com.github.pauloruszel.model.Pokemon;

import java.util.List;
import java.util.stream.Collectors;

public class PokemonConverter {

    private PokemonConverter() {
        super();
    }

    public static Pokemon converter(PokemonDTO pokemonDTO) {
        var pokemon = new Pokemon();
        pokemon.setId(pokemonDTO.getId());
        pokemon.setNomePokemon(pokemonDTO.getNomePokemon());
        pokemon.setAltura(pokemonDTO.getAltura());
        pokemon.setCategoria(pokemonDTO.getCategoria());
        pokemon.setGenero(pokemonDTO.getGenero());
        pokemon.setPeso(pokemonDTO.getPeso());
        return pokemon;
    }

    public static Pokemon converter(Pokemon entidade, PokemonDTO dto) {
        entidade.setId(dto.getId());
        entidade.setNomePokemon(dto.getNomePokemon());
        entidade.setAltura(dto.getAltura());
        entidade.setCategoria(dto.getCategoria());
        entidade.setGenero(dto.getGenero());
        entidade.setPeso(dto.getPeso());
        return entidade;
    }


    public static PokemonDTO converter(Pokemon pokemon) {
        var pokemonDTO = new PokemonDTO();
        pokemonDTO.setId(pokemon.getId());
        pokemonDTO.setNomePokemon(pokemon.getNomePokemon());
        pokemonDTO.setAltura(pokemon.getAltura());
        pokemonDTO.setCategoria(pokemon.getCategoria());
        pokemonDTO.setGenero(pokemon.getGenero());
        pokemonDTO.setPeso(pokemon.getPeso());
        return pokemonDTO;
    }

    public static List<PokemonDTO> mapperAll(List<Pokemon> pokemons) {
        return pokemons.stream().map(PokemonConverter::converter).collect(Collectors.toList());
    }
}
