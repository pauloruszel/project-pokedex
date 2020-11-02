package com.github.pauloruszel.service;

import com.github.pauloruszel.converter.PokemonConverter;
import com.github.pauloruszel.dto.MensagemRetornoDTO;
import com.github.pauloruszel.dto.PokemonDTO;
import com.github.pauloruszel.model.Pokemon;
import com.github.pauloruszel.util.MensagemUtil;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class PokemonService {

    public List<Pokemon> getAllPokemons() {
        return Pokemon.listAll();
    }

    public PokemonDTO getPokemonById(Long id) {
        if (id != null && id != 0) {
            Pokemon pokemon = Pokemon.findById(id);
            if (pokemon != null) {
                return PokemonConverter.converter(pokemon);
            }
        }
        return null;
    }

    public PokemonDTO savePokemon(PokemonDTO dto) {
        PokemonDTO retorno = null;
        if (dto != null) {
            Pokemon pokemon = PokemonConverter.converter(dto);
            pokemon.persist();
            retorno = PokemonConverter.converter(pokemon);
        }
        return retorno;
    }

    public PokemonDTO updatePokemon(PokemonDTO dto) {
        if (dto.getId() == null) {
            return null;
        }

        Pokemon pokemon = Pokemon.findById(dto.getId());
        if (pokemon != null) {
            pokemon = PokemonConverter.converter(pokemon, dto);
            return PokemonConverter.converter(pokemon);
        }
        return null;
    }

    public MensagemRetornoDTO deletePokemon(Long id) {
        Pokemon pokemon = Pokemon.findById(id);
        if (pokemon != null) {
            pokemon.delete();
            return new MensagemRetornoDTO(MensagemUtil.MSG_REGISTRO_EXCLUIDO);
        }
        return new MensagemRetornoDTO(MensagemUtil.MSG_REGISTRO_NAO_ENCONTRADO);
    }

}
