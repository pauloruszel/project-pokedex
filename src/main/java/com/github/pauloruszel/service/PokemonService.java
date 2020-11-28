package com.github.pauloruszel.service;

import com.github.pauloruszel.domain.dtos.MensagemRetornoDTO;
import com.github.pauloruszel.domain.dtos.PokemonDTO;
import com.github.pauloruszel.domain.model.Pokemon;
import com.github.pauloruszel.domain.util.MensagemUtil;
import com.github.pauloruszel.exception.ParametroInvalidoException;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@ApplicationScoped
public class PokemonService extends BaseService {

    @Inject
    HabilidadeService habilidadeService;

    @Inject
    FraquezaService fraquezaService;

    @Inject
    TipoService tipoService;

    public List<Pokemon> findAll() {
        return Pokemon.listAll();
    }

    public PokemonDTO getById(final Long id) throws ParametroInvalidoException {
        if (id == null)
            throw new ParametroInvalidoException(MensagemUtil.MSG_PARAMETRO_ID_INVALIDO);

        final Pokemon pokemon = Pokemon.findById(id);
        if (Objects.isNull(pokemon))
            throw new ParametroInvalidoException(MensagemUtil.MSG_REGISTRO_NAO_ENCONTRADO);

        return getConverter().map(pokemon, PokemonDTO.class);
    }

    public PokemonDTO save(final PokemonDTO dto) throws ParametroInvalidoException {
        if (Objects.isNull(dto))
            throw new ParametroInvalidoException(MensagemUtil.MSG_PARAMETRO_DTO_INVALIDO);

        final Pokemon pokemon = getConverter().map(dto, Pokemon.class);
        pokemon.persist();
        return this.saveDependencies(dto, pokemon.getId());
    }

    public PokemonDTO update(final PokemonDTO dto) throws ParametroInvalidoException {
        if (dto == null || dto.getId() == null)
            throw new ParametroInvalidoException(MensagemUtil.MSG_PARAMETRO_DTO_INVALIDO);

        Pokemon pokemon = Pokemon.findById(dto.getId());
        if (Objects.isNull(pokemon))
            throw new ParametroInvalidoException(MensagemUtil.MSG_REGISTRO_NAO_ENCONTRADO);

        pokemon = getConverter().map(dto, Pokemon.class);
        return getConverter().map(pokemon, PokemonDTO.class);
    }

    public MensagemRetornoDTO delete(final Long id) throws ParametroInvalidoException {
        if (id == null)
            throw new ParametroInvalidoException(MensagemUtil.MSG_PARAMETRO_ID_INVALIDO);

        final Pokemon pokemon = Pokemon.findById(id);
        if (Objects.isNull(pokemon))
            throw new ParametroInvalidoException(MensagemUtil.MSG_REGISTRO_NAO_ENCONTRADO);

        pokemon.delete();
        return new MensagemRetornoDTO(MensagemUtil.MSG_REGISTRO_EXCLUIDO);
    }


    @Transactional(Transactional.TxType.REQUIRES_NEW)
    private PokemonDTO saveDependencies(final PokemonDTO dto, final Long idPokemon) throws ParametroInvalidoException {
        if (idPokemon == null)
            throw new ParametroInvalidoException(MensagemUtil.MSG_PARAMETRO_ID_INVALIDO);

        dto.setId(idPokemon);
        fraquezaService.savePokemonToFraqueza(dto, idPokemon);
        habilidadeService.savePokemonToHabilidade(dto, idPokemon);
        tipoService.savePokemonToTipo(dto, idPokemon);

        return dto;
    }

//    private PokemonDTO findDependencies(final PokemonDTO dto) throws ParametroInvalidoException {
//        if (dto == null)
//            throw new ParametroInvalidoException(MensagemUtil.MSG_PARAMETRO_DTO_INVALIDO);
//
//        final Pokemon pokemon = Pokemon.findById(dto.getId());
//        if (pokemon == null)
//            throw new ParametroInvalidoException(MensagemUtil.MSG_REGISTRO_NAO_ENCONTRADO);
//
//        var fraqueza = fraquezaService.getByIdPokemon(pokemon);
//        if (Objects.nonNull(fraqueza)) {
//            dto.setFraqueza(fraqueza);
//        }
//
//        var habilidade = habilidadeService.getByIdPokemon(pokemon);
//        if (Objects.nonNull(habilidade)) {
//            dto.setHabilidade(habilidade);
//        }
//
//        var tipo = tipoService.getByIdPokemon(pokemon);
//        if (Objects.nonNull(tipo)) {
//            dto.setTipo(tipo);
//        }
//
//        return dto;
//    }


}
