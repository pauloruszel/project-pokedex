package com.github.pauloruszel.converter;

import com.github.pauloruszel.dto.TipoDTO;
import com.github.pauloruszel.model.Tipo;

import java.util.List;
import java.util.stream.Collectors;

public class TipoConverter {

    private TipoConverter() {
        super();
    }

    public static Tipo converter(TipoDTO tipoDTO) {
        var tipo = new Tipo();
        tipo.setId(tipoDTO.getId());
        tipo.setNomeTipo(tipoDTO.getNomeTipo());
        tipo.setPokemon(PokemonConverter.converter(tipoDTO.getPokemonDTO()));
        return tipo;
    }


    public static TipoDTO converter(Tipo tipo) {
        var tipoDTO = new TipoDTO();
        tipoDTO.setId(tipo.getId());
        tipoDTO.setNomeTipo(tipo.getNomeTipo());
        tipoDTO.setPokemonDTO(PokemonConverter.converter(tipo.getPokemon()));
        return tipoDTO;
    }

    public static List<TipoDTO> mapperAll(List<Tipo> tipos) {
        return tipos.stream().map(TipoConverter::converter).collect(Collectors.toList());
    }
}
