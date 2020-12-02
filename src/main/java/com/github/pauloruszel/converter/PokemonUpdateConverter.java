package com.github.pauloruszel.converter;

import com.github.pauloruszel.domain.dtos.PokemonDTO;
import com.github.pauloruszel.domain.model.Caracteristica;
import com.github.pauloruszel.domain.model.Categoria;
import com.github.pauloruszel.domain.model.Genero;
import com.github.pauloruszel.domain.model.Pokemon;
import org.modelmapper.ModelMapper;

import java.util.Objects;

public class PokemonUpdateConverter {

    private static final ModelMapper modelMapper = new ModelMapper();


    private PokemonUpdateConverter() {
        super();
    }

    public static Pokemon converter(final Pokemon entidade, final PokemonDTO dto) {
        entidade.setId(dto.getId());
        entidade.setNomePokemon(dto.getNomePokemon());

        if (Objects.nonNull(dto.getCategoria())) {
            entidade.setCategoria(modelMapper.map(dto.getCategoria(), Categoria.class));
        }
        if (Objects.nonNull(dto.getGenero())) {
            entidade.setGenero(modelMapper.map(dto.getGenero(), Genero.class));
        }
        if (Objects.nonNull(dto.getCaracteristica())) {
            entidade.setCaracteristica(modelMapper.map(dto.getCaracteristica(), Caracteristica.class));

        }
        return entidade;
    }

}
