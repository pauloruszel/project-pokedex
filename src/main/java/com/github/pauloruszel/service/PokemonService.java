package com.github.pauloruszel.service;

import com.github.pauloruszel.domain.dtos.MensagemRetornoDTO;
import com.github.pauloruszel.domain.dtos.PokemonDTO;
import com.github.pauloruszel.domain.model.Pokemon;
import com.github.pauloruszel.domain.util.MensagemUtil;
import com.github.pauloruszel.exception.ParametroInvalidoException;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@ApplicationScoped
public class PokemonService extends BaseService {

    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public List<Pokemon> findAll() {
        return Pokemon.listAll();
    }

    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public PokemonDTO getById(final Long id) throws ParametroInvalidoException {
        if (id == null)
            throw new ParametroInvalidoException(MensagemUtil.MSG_PARAMETRO_ID_INVALIDO);

        final Pokemon pokemon = Pokemon.findById(id);
        if (Objects.isNull(pokemon))
            throw new ParametroInvalidoException(MensagemUtil.MSG_REGISTRO_NAO_ENCONTRADO);

        return getConverter().map(pokemon, PokemonDTO.class);
    }

    @Transactional
    public PokemonDTO save(final PokemonDTO dto) throws ParametroInvalidoException {
        if (Objects.isNull(dto))
            throw new ParametroInvalidoException(MensagemUtil.MSG_PARAMETRO_DTO_INVALIDO);

        final Pokemon pokemon = getConverter().map(dto, Pokemon.class);
        pokemon.persist();
        return getConverter().map(pokemon, PokemonDTO.class);
    }

    @Transactional
    public PokemonDTO update(final PokemonDTO dto) throws ParametroInvalidoException {
        if (dto == null || dto.getId() == null)
            throw new ParametroInvalidoException(MensagemUtil.MSG_PARAMETRO_DTO_INVALIDO);

        Pokemon pokemon = Pokemon.findById(dto.getId());
        if (Objects.isNull(pokemon))
            throw new ParametroInvalidoException(MensagemUtil.MSG_REGISTRO_NAO_ENCONTRADO);

        pokemon = getConverter().map(dto, Pokemon.class);
        return getConverter().map(pokemon, PokemonDTO.class);
    }

    @Transactional
    public MensagemRetornoDTO delete(final Long id) throws ParametroInvalidoException {
        if (id == null)
            throw new ParametroInvalidoException(MensagemUtil.MSG_PARAMETRO_ID_INVALIDO);

        final Pokemon pokemon = Pokemon.findById(id);
        if (Objects.isNull(pokemon))
            throw new ParametroInvalidoException(MensagemUtil.MSG_REGISTRO_NAO_ENCONTRADO);

        pokemon.delete();
        return new MensagemRetornoDTO(MensagemUtil.MSG_REGISTRO_EXCLUIDO);
    }

}
