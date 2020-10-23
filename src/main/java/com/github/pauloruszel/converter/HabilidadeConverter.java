package com.github.pauloruszel.converter;

import com.github.pauloruszel.dto.HabilidadeDTO;
import com.github.pauloruszel.model.Habilidade;

import java.util.List;
import java.util.stream.Collectors;

public class HabilidadeConverter {

    private HabilidadeConverter() {
        super();
    }

    public static Habilidade converter(HabilidadeDTO habilidadeDTO) {
        var habilidade = new Habilidade();
        habilidade.setId(habilidadeDTO.getId());
        habilidade.setNomeHabilidade(habilidadeDTO.getNomeHabilidade());
        habilidade.setPokemon(PokemonConverter.converter(habilidadeDTO.getPokemonDTO()));
        return habilidade;
    }


    public static HabilidadeDTO converter(Habilidade habilidade) {
        var habilidadeDTO = new HabilidadeDTO();
        habilidadeDTO.setId(habilidade.getId());
        habilidadeDTO.setNomeHabilidade(habilidade.getNomeHabilidade());
        habilidadeDTO.setPokemonDTO(PokemonConverter.converter(habilidade.getPokemon()));
        return habilidadeDTO;
    }

    public static List<HabilidadeDTO> mapperAll(List<Habilidade> habilidades) {
        return habilidades.stream().map(HabilidadeConverter::converter).collect(Collectors.toList());
    }
}
