package com.github.pauloruszel.converter;

import com.github.pauloruszel.dto.FraquezaDTO;
import com.github.pauloruszel.model.Fraqueza;

import java.util.List;
import java.util.stream.Collectors;

public class FraquezaConverter {

    private FraquezaConverter() {
        super();
    }

    public static Fraqueza converter(FraquezaDTO fraquezaDTO) {
        var fraqueza = new Fraqueza();
        fraqueza.setId(fraquezaDTO.getId());
        fraqueza.setNomeFraqueza(fraquezaDTO.getNomeFraqueza());
        fraqueza.setPokemon(PokemonConverter.converter(fraquezaDTO.getPokemonDTO()));
        return fraqueza;
    }


    public static FraquezaDTO converter(Fraqueza fraqueza) {
        var fraquezaDTO = new FraquezaDTO();
        fraquezaDTO.setId(fraqueza.getId());
        fraquezaDTO.setNomeFraqueza(fraqueza.getNomeFraqueza());
        fraquezaDTO.setPokemonDTO(PokemonConverter.converter(fraqueza.getPokemon()));
        return fraquezaDTO;
    }

    public static List<FraquezaDTO> mapperAll(List<Fraqueza> fraquezas) {
        return fraquezas.stream().map(FraquezaConverter::converter).collect(Collectors.toList());
    }
}
